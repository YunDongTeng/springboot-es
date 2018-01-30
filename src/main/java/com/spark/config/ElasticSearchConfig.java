package com.spark.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * Created by admin on 2018/1/30.
 */

@Configuration
@ConfigurationProperties("spring.data.elasticsearch")
public class ElasticSearchConfig {

    private String clusterName;

    private String clusterNodes;


    @Bean("client")
    public TransportClient getClient() throws Exception {

        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        TransportClient client = new PreBuiltTransportClient(settings);

        for (String node : clusterNodes.split(",")) {
            String host = node.split(":")[0];
            String port = node.split(":")[1];
            client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), Integer.parseInt(port)));
        }

        return client;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }
}

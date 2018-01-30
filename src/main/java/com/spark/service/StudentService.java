package com.spark.service;

import com.google.gson.Gson;
import com.spark.model.Student;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/30.
 */
@Service
public class StudentService {


    @Autowired
    private TransportClient client;

    public Object fillData() {

        Student stu = new Student("张八", 15, "河北", 17);

        Gson gson = new Gson();
        String content = gson.toJson(stu);
        IndexResponse response = client.prepareIndex("student", "basic").setSource(content, XContentType.JSON).get();

        return response.getId();
    }

    public List<Student> findAll() {

        List<Student> list = new ArrayList<Student>();

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch().setTypes("basic");

        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();

        SearchHits hits = searchResponse.getHits();

        for (SearchHit hit : hits.getHits()) {
            String jsonStr = hit.getSourceAsString();
            Student stu = new Gson().fromJson(jsonStr, Student.class);
            list.add(stu);
        }
        return list;
    }

}

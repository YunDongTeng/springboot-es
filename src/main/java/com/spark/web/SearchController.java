package com.spark.web;

import com.spark.model.Student;
import com.spark.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2018/1/30.
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("/fill")
    public Object fill() {
        return studentService.fillData();
    }

    @RequestMapping("/findAll")
    public List<Student> findAll() {

        logger.info("log info ...");
        logger.error("log error ...");

        logger.debug("log debug ...");
        return studentService.findAll();
    }

}

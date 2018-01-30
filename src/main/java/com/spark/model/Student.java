package com.spark.model;

import java.lang.annotation.Documented;

/**
 * Created by admin on 2018/1/30.
 */

public class Student {

    private String id;
    private String name;
    private int age;
    private String address;
    private int classId;

    public Student() {
    }

    public Student(String name, int age, String address, int classId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.classId = classId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}



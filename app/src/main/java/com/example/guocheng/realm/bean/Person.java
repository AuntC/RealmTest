package com.example.guocheng.realm.bean;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by guocheng on 16-7-26.
 */
public class Person extends RealmObject {

    @PrimaryKey
    private String id;
    @Index
    private String name;
    private int age;
    private Dog dog;

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

    public RealmObject getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

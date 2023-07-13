package com.jbground.jpa.entity;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

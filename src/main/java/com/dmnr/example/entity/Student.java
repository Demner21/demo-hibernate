package com.dmnr.example.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String enrollmentId;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Student() {
    }

    public Student(Integer id, String name, String enrollmentId, Guide guide) {
        this.id = id;
        this.name = name;
        this.enrollmentId = enrollmentId;
        this.guide = guide;
    }
}

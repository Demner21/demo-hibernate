package com.dmnr.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String enrollmentId;

    @ManyToOne(cascade = CascadeType.PERSIST)
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollmentId='" + enrollmentId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId().equals(student.getId()) && getName().equals(student.getName()) && getEnrollmentId().equals(student.getEnrollmentId()) && getGuide().equals(student.getGuide());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEnrollmentId(), getGuide());
    }
}

package com.attendance.attendence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Date dateOfBirth;
    private String location;
    private String department;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    public void setId(Long id) {
    }
}

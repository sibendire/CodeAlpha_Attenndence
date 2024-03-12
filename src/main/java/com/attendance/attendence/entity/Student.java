package com.attendance.attendence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Setter
@Generated
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


}

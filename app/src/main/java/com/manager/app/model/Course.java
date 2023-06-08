package com.manager.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "course_table")
public class Course {
    @Id
    private String course_name;
    private String description;
    private String department;
    private String teacher;
//    @ManyToMany(mappedBy = "courses")
//    Set<User> users;

    @OneToMany(
            mappedBy = "course_table",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserCourse> usercourses = new ArrayList<>();
}

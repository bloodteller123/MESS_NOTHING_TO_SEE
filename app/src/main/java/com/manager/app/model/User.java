package com.manager.app.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_table")
public class User extends BaseModel{
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String mobile;

    private String status;

    private String salt;
//
//    @JoinTable(
//            name = "course_in",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "course_name"))
//    @ManyToMany
//    Set<Course> courses;

    @OneToMany(
            mappedBy = "user_table",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserCourse> usercourses = new ArrayList<>();
}

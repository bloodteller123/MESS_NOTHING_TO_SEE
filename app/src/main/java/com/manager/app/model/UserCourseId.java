package com.manager.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserCourseId implements Serializable {
    @Column(name = "id")
    private Long userId;

    @Column(name = "course_name")
    private String courseName;
}

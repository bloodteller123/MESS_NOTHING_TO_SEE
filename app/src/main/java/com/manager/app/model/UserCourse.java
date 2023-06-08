package com.manager.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="usercourse_table", uniqueConstraints={@UniqueConstraint(columnNames={"id", "course_name"})})
//https://www.baeldung.com/jpa-many-to-many
public class UserCourse {
    @EmbeddedId
    UserCourseId userCourseId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id")
    User user_table;

    @ManyToOne
    @MapsId("course_name")
    @JoinColumn(name = "course_name")
    Course course_table;

    private Date startDate;
    private Date endDate;


}

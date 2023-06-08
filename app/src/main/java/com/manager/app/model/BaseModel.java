package com.manager.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@MappedSuperclass
//https://vladmihalcea.com/how-to-inherit-properties-from-a-base-class-entity-using-mappedsuperclass-with-jpa-and-hibernate/
public class BaseModel {
    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_sequence")
    private Long id;

    private String createdBy;

    private Date createTime;
}

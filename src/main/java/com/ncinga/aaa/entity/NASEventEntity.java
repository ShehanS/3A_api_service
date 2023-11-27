package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_nas")
public class NASEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nas_id;
    private String nas_name;
    private String nas_type;
    private String nas_attrgroup;
    private String nas_secret;
    private Date created_date;
}

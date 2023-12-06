package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_nas")
public class NASConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nas_id;
    private String nas_name;
    private String nas_type;
    @ManyToOne()
    @JoinColumn(name = "nas_attrgroup")
    private NASAttributeGroupEntity nas_attrgroup;
    private String nas_secret;
    @CreationTimestamp
    private Timestamp created_date;


}

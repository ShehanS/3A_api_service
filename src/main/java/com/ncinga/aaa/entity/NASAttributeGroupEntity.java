package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_nas_attrgroup")
public class NASAttributeGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;
    private String group_name;
    private String group_description;
}

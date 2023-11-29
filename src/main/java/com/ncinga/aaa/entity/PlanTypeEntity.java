package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bb_plan_type")
public class PlanTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_id;
    private String type_name;
    private String description;
}

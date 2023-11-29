package com.ncinga.aaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_plan_attribute")
public class PlanAttributeEntity {
    @Id
    private int plan_id;
    private String attribute_name;
    private String attribute_value;
    private int attribute_group;
    private String include_plan_state;
    private String status;
}

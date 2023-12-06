package com.ncinga.aaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bb_plan_parameter")
@Entity
public class PlanParameterEntity {
    @Id
    private int parameter_id;
    private int plan_id;
    private String parameter_name;
    private String parameter_value;
    private int reject_on_failure;
}

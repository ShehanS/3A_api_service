package com.ncinga.aaa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bb_parameter_meta")
public class ParameterMetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parameter_id;
    private String parameter_name;
    private String parameter_lib_path;
    private String parameter_method_symbol;
    private String exec_phase;
    private String parameter_status;
}


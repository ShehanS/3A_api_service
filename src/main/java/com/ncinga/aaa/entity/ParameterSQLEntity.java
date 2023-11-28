package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bb_parameter_sql_action")
public class ParameterSQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int action_id;
    private String action_name;
    private String parameter_name;
    private String action_sql;
    private int action_seq;
    private int match_return;
    private String entity;
}

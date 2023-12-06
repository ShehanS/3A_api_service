package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bb_subscriber_parameter")
public class SubscriberParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parameter_id;
    private int subscriber_id;
    private String parameter_name;
    private String parameter_value;
    private int reject_on_failure;
}

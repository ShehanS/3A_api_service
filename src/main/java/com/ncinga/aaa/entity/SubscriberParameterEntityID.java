package com.ncinga.aaa.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberParameterEntityID implements Serializable {
    private int subscriber_id;
    private String parameter_name;
    private String parameter_value;
    private int reject_on_failure;

}

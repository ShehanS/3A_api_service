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
@Entity
@Table(name = "bb_subscriber_parameter")
public class SubscriberParameterEntity {
    @Id
    private SubscriberParameterEntityID subscriberParameterEntityID;
}

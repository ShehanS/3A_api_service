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
@Table(name = "bb_nas_subscriber_avp")
public class NasSubscriberEntity {
    @Id
    private int subscriber_id;
    private int attribute_group;
    private String attribute;
    private String operation;
    private String value;
}

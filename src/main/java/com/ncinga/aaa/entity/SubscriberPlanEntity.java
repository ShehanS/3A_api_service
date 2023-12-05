package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_subscriber_plan")
public class SubscriberPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instance_id;
    private int subscriber_id;
    private int plan_id;
    private String plan_state;
    @Transient
    private Date status_date;
    @Transient
    private Date created_date;
}

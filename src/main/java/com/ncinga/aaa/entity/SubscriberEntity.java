package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_subscriber")
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriber_id;
    private String username;
    private String password;
    private String status;
    private String contact_no;
    private String email;
    @CreationTimestamp
    private Timestamp created_date;
    @CreationTimestamp
    private Timestamp updated_time;
}

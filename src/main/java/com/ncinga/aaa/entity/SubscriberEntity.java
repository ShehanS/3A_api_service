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
@Table(name = "bb_subscriber")
public class SubscriberEntity {
    @Id
    private int subscriber_id;
    private String username;
    private String password;
    private String status;
    private String contact_no;
    private String email;
}

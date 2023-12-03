package com.ncinga.aaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "bb_pod_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DMEventEntity {
    @Id
    private int event_id;
    private String username;
    private String status;
    private String event_response;
    private Date request_datetime;
}

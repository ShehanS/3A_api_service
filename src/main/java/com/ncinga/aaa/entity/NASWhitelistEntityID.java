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
public class NASWhitelistEntityID  implements Serializable {
    private int subscriber_id;
    private String nas_id_pattern;
}

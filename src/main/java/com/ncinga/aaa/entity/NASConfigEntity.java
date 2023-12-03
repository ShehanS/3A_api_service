package com.ncinga.aaa.entity;

import com.ncinga.aaa.validator.NotBlankWithFieldName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_nas")
public class NASConfigEntity {
    @Id
    private int nas_id;
    private String nas_name;
    private String nas_type;
    private int nas_attrgroup;
    private String nas_secret;
    private Date created_date;
}

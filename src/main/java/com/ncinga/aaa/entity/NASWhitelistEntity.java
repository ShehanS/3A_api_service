package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bb_subscriber_nas_wihitelist")
public class NASWhitelistEntity {
      @Id
      private  NASWhitelistEntityID id;
}

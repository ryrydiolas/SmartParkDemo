package com.api.demo.smartpark.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="vehicle")
public class VehicleEntity {


    @Id
    @Column(length=20)
    private String licensePlate;



    private String type;


    private String ownerName;


    private String parkedLotId;


}
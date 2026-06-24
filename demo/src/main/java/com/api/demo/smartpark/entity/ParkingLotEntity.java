package com.api.demo.smartpark.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="parking_lot")
public class ParkingLotEntity {


    @Id
    @Column(length = 50)
    private String lotId;


    private String location;


    private Integer capacity;


    private Integer occupiedSpaces = 0;


    public Integer getAvailableSpaces(){

        return capacity - occupiedSpaces;
    }


}
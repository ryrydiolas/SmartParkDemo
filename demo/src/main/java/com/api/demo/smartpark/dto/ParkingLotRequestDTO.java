package com.api.demo.smartpark.dto;


import lombok.Data;

import javax.validation.constraints.*;


@Data
public class ParkingLotRequestDTO {


@NotBlank
private String lotId;


@NotBlank
private String location;


@Min(1)
private Integer capacity;


}
package com.api.demo.smartpark.dto;


import lombok.Data;


import javax.validation.constraints.*;


@Data
public class VehicleRequestDTO {


@NotBlank
@Pattern(
regexp="[A-Za-z0-9-]+",
message="Invalid license plate"
)
private String licensePlate;



@NotBlank
@Pattern(
regexp="[A-Za-z ]+",
message="Owner name only letters"
)
private String ownerName;



@NotBlank
private String type;


}
package com.example.apelsin_restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDto {
    private UUID ordId;
    private UUID prId;
    private short quantity;

}

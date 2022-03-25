package com.example.apelsin_restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceDto {
    private UUID ordId;
    private double ammount;
    private Date issued;
    private Date due;
}

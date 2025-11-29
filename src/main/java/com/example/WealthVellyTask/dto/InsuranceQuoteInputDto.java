package com.example.WealthVellyTask.dto;

import lombok.Data;

@Data
public class InsuranceQuoteInputDto {
    private Integer clientAge;
    private Double coverageAmount;
    private Double basePremium;
}

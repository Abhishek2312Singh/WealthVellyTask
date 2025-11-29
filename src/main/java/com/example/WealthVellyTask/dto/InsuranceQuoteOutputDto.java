package com.example.WealthVellyTask.dto;

import lombok.Data;

@Data
public class InsuranceQuoteOutputDto {
    private Long id;
    private Integer clientAge;
    private Double coverageAmount;
    private Double basePremium;
    private Double finalPrwmium;
}

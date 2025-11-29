package com.example.WealthVellyTask.controller;

import com.example.WealthVellyTask.dto.InsuranceQuoteInputDto;
import com.example.WealthVellyTask.dto.InsuranceQuoteOutputDto;
import com.example.WealthVellyTask.service.InsuranceQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class InsuranceQuoteController {
    @Autowired
    private InsuranceQuoteService insuranceQuoteService;

//  API for Adding quotation details
    @PostMapping("/insurance-quotes")
    public ResponseEntity<String> addQuotation(@RequestBody InsuranceQuoteInputDto insuranceQuoteInputDto){
        return ResponseEntity.ok(insuranceQuoteService.addInsuranceQuote(insuranceQuoteInputDto));
    }
//    API to get quotation details by id
    @GetMapping("/insurance-quotes/{id}")
    public ResponseEntity<?> getQuotationById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(insuranceQuoteService.getQuotationById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

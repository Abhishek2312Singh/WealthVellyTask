package com.example.WealthVellyTask.service;

import com.example.WealthVellyTask.dto.InsuranceQuoteInputDto;
import com.example.WealthVellyTask.dto.InsuranceQuoteOutputDto;
import com.example.WealthVellyTask.entity.InsuranceQuote;
import com.example.WealthVellyTask.repository.InsuranceQuoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceQuoteService {
    @Autowired
    private InsuranceQuoteRepo insuranceQuoteRepo;

//    Logic to  get insurance quotation and calculating the final premium and storing it in db
    public String addInsuranceQuote(InsuranceQuoteInputDto insuranceQuoteInputDto){
        Double basePremium = insuranceQuoteInputDto.getBasePremium();
        Double finalPremium = basePremium;
        InsuranceQuote insuranceQuote = new InsuranceQuote();
        insuranceQuote.setClientAge(insuranceQuoteInputDto.getClientAge());
        insuranceQuote.setBasePremium(basePremium);
        insuranceQuote.setCoverageAmount(insuranceQuoteInputDto.getCoverageAmount());

        if(insuranceQuoteInputDto.getClientAge()<30){
            Double discount = basePremium * .1;
            finalPremium -= discount;
        }
        if(insuranceQuoteInputDto.getCoverageAmount()>500000){
            Double surcharge = basePremium * .05;
            finalPremium += surcharge;
        }
        insuranceQuote.setFinalPremium(finalPremium);

        return "Your Insurance Quotation Saved.\n" +
                "Search By Quotation Id : " + insuranceQuoteRepo.save(insuranceQuote).getId();
    }
//Method to get insurance quotation by id which user filled
    public InsuranceQuoteOutputDto getQuotationById(Long id){
        InsuranceQuote insuranceQuote = insuranceQuoteRepo.findById(id).orElse(null);
        if(insuranceQuote == null){
            throw new RuntimeException("Quotation Not Found");
        }
        InsuranceQuoteOutputDto insuranceQuoteOutputDto = new InsuranceQuoteOutputDto();

        insuranceQuoteOutputDto.setId(insuranceQuote.getId());
        insuranceQuoteOutputDto.setBasePremium(insuranceQuote.getBasePremium());
        insuranceQuoteOutputDto.setClientAge(insuranceQuote.getClientAge());
        insuranceQuoteOutputDto.setCoverageAmount(insuranceQuote.getCoverageAmount());
        insuranceQuoteOutputDto.setFinalPrwmium(insuranceQuote.getFinalPremium());

        return insuranceQuoteOutputDto;
    }
}

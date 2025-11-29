package com.example.WealthVellyTask.repository;

import com.example.WealthVellyTask.entity.InsuranceQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceQuoteRepo extends JpaRepository<InsuranceQuote, Long> {
}

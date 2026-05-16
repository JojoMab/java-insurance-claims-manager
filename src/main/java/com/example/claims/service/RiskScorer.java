package com.example.claims.service;

import com.example.claims.model.Claim;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RiskScorer {
    public int calculateRiskScore(Claim claim) {
        int score = 1;
        if (claim.getAmount() > 10000) {
            score += 4;
        } else if (claim.getAmount() > 5000) {
            score += 2;
        }
        if (claim.getClaimType() == Claim.ClaimType.LIABILITY) {
            score += 3;
        }
        long daysSinceClaim = ChronoUnit.DAYS.between(claim.getDate(), LocalDate.now());
        if (daysSinceClaim <= 30) {
            score += 2;
        }
        return Math.max(1, Math.min(10, score));
    }
}

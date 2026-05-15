package de.jojomab.claims.service;

import de.jojomab.claims.model.Claim;

public class RiskScorer {
    public int score(Claim claim) {
        int score = 10;
        if (claim.getAmount() > 5000) score += 35;
        if (claim.getCustomerYears() < 2) score += 20;
        if (claim.getType().equalsIgnoreCase("liability")) score += 10;
        return Math.min(score, 100);
    }

    public String priority(Claim claim) {
        int score = score(claim);
        if (score >= 60) return "high";
        if (score >= 35) return "medium";
        return "low";
    }
}

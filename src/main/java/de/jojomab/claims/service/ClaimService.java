package de.jojomab.claims.service;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimAssessment;
import java.util.List;

public class ClaimService {
    private final RiskScorer riskScorer;

    public ClaimService(RiskScorer riskScorer) {
        this.riskScorer = riskScorer;
    }

    public List<ClaimAssessment> analyze(List<Claim> claims) {
        return claims.stream()
            .map(claim -> new ClaimAssessment(
                claim,
                riskScorer.score(claim),
                riskScorer.priority(claim),
                isPlausible(claim)
            ))
            .toList();
    }

    public boolean isPlausible(Claim claim) {
        return claim.getAmount() > 0 && claim.getCustomerYears() >= 0;
    }
}

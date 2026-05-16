package com.example.claims;

import com.example.claims.model.Claim;
import com.example.claims.service.RiskScorer;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RiskScorerTest {
    private final RiskScorer scorer = new RiskScorer();

    @Test
    void scoresLargeLiabilityClaimAsHighRisk() {
        Claim claim = new Claim("C001", "Anna Weber", Claim.ClaimType.LIABILITY, 15000, LocalDate.now().minusDays(5), Claim.ClaimStatus.RECEIVED);
        assertTrue(scorer.calculateRiskScore(claim) >= 8);
    }

    @Test
    void keepsSmallOlderClaimLower() {
        Claim claim = new Claim("C002", "Lukas Klein", Claim.ClaimType.HEALTH, 900, LocalDate.now().minusDays(90), Claim.ClaimStatus.APPROVED);
        assertEquals(1, scorer.calculateRiskScore(claim));
    }

    @Test
    void capsScoreAtTen() {
        Claim claim = new Claim("C003", "Mira Hoffmann", Claim.ClaimType.LIABILITY, 30000, LocalDate.now(), Claim.ClaimStatus.IN_REVIEW);
        assertEquals(10, scorer.calculateRiskScore(claim));
    }
}

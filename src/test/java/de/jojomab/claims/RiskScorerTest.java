package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.model.ClaimType;
import de.jojomab.claims.service.RiskScorer;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RiskScorerTest {

    private final RiskScorer scorer = new RiskScorer();

    @Test
    void scoresHighRiskLiabilityClaim() {
        Claim claim = new Claim("C101", "David Klein", ClaimType.LIABILITY, 12500.00, LocalDate.now().minusDays(5), ClaimStatus.IN_REVIEW, 0);

        assertEquals("high", scorer.priority(claim));
        assertTrue(scorer.score(claim) >= 8);
    }

    @Test
    void scoresMediumRiskAccidentClaim() {
        Claim claim = new Claim("C102", "Maria Fischer", ClaimType.ACCIDENT, 7200.00, LocalDate.now().minusDays(80), ClaimStatus.RECEIVED, 0);

        assertEquals("medium", scorer.priority(claim));
        assertTrue(scorer.score(claim) >= 5 && scorer.score(claim) < 8);
    }

    @Test
    void scoresLowRiskHealthClaim() {
        Claim claim = new Claim("C103", "Anna Weber", ClaimType.HEALTH, 900.00, LocalDate.now().minusDays(90), ClaimStatus.APPROVED, 0);

        assertEquals("low", scorer.priority(claim));
        assertTrue(scorer.score(claim) < 5);
    }
}

package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.service.RiskScorer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RiskScorerTest {
    @Test
    void scoresHighRiskClaim() {
        RiskScorer scorer = new RiskScorer();
        Claim claim = new Claim("C101", "liability", 8500, 1, ClaimStatus.RECEIVED);

        assertEquals("high", scorer.priority(claim));
        assertTrue(scorer.score(claim) >= 60);
    }
}

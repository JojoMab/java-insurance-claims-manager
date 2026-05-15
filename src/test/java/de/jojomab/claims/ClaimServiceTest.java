package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimAssessment;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.service.ClaimService;
import de.jojomab.claims.service.RiskScorer;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClaimServiceTest {
    @Test
    void analyzesClaimsWithPriorityAndPlausibility() {
        ClaimService service = new ClaimService(new RiskScorer());
        Claim claim = new Claim("C200", "car", 1800, 4, ClaimStatus.IN_REVIEW);

        List<ClaimAssessment> assessments = service.analyze(List.of(claim));

        assertEquals(1, assessments.size());
        assertTrue(assessments.get(0).isPlausible());
    }
}

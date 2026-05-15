package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimAssessment;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.model.ClaimType;
import de.jojomab.claims.service.ClaimService;
import de.jojomab.claims.service.RiskScorer;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClaimServiceTest {

    private final ClaimService service = new ClaimService(new RiskScorer());

    @Test
    void analyzesClaimsWithPriorityAndPlausibility() {
        Claim claim = new Claim("C200", "Mina Keller", ClaimType.ACCIDENT, 1800.00, LocalDate.now().minusDays(10), ClaimStatus.IN_REVIEW, 0);

        List<ClaimAssessment> assessments = service.analyze(List.of(claim));

        assertEquals(1, assessments.size());
        assertTrue(assessments.get(0).isPlausible());
    }

    @Test
    void filtersClaimsByStatus() {
        Claim openClaim = new Claim("C201", "Tom Bauer", ClaimType.HEALTH, 900.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);
        Claim approvedClaim = new Claim("C202", "Lena Wolf", ClaimType.PROPERTY, 2500.00, LocalDate.now(), ClaimStatus.APPROVED, 0);

        List<Claim> receivedClaims = service.filterByStatus(List.of(openClaim, approvedClaim), ClaimStatus.RECEIVED);

        assertEquals(1, receivedClaims.size());
        assertEquals("C201", receivedClaims.get(0).getId());
    }

    @Test
    void calculatesTotalAmount() {
        Claim first = new Claim("C203", "Noah Klein", ClaimType.PROPERTY, 1000.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);
        Claim second = new Claim("C204", "Emma Koch", ClaimType.HEALTH, 500.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);

        assertEquals(1500.00, service.calculateTotalAmount(List.of(first, second)));
    }

    @Test
    void returnsHighRiskClaims() {
        Claim highRisk = new Claim("C205", "David Klein", ClaimType.LIABILITY, 15000.00, LocalDate.now().minusDays(2), ClaimStatus.IN_REVIEW, 0);
        Claim lowRisk = new Claim("C206", "Anna Weber", ClaimType.HEALTH, 300.00, LocalDate.now().minusDays(90), ClaimStatus.APPROVED, 0);

        List<ClaimAssessment> highRiskClaims = service.getHighRiskClaims(List.of(highRisk, lowRisk));

        assertEquals(1, highRiskClaims.size());
        assertEquals("C205", highRiskClaims.get(0).getClaim().getId());
    }
}

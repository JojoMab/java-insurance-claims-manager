package com.example.claims;

import com.example.claims.model.Claim;
import com.example.claims.service.ClaimService;
import com.example.claims.service.RiskScorer;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClaimServiceTest {
    private final ClaimService service = new ClaimService(new RiskScorer());

    @Test
    void filtersByStatus() {
        List<Claim> claims = List.of(
            new Claim("C001", "Anna", Claim.ClaimType.HEALTH, 1000, LocalDate.now(), Claim.ClaimStatus.RECEIVED),
            new Claim("C002", "Ben", Claim.ClaimType.PROPERTY, 2000, LocalDate.now(), Claim.ClaimStatus.APPROVED)
        );
        assertEquals(1, service.filterByStatus(claims, Claim.ClaimStatus.RECEIVED).size());
    }

    @Test
    void calculatesTotalAmount() {
        List<Claim> claims = List.of(
            new Claim("C001", "Anna", Claim.ClaimType.HEALTH, 1000, LocalDate.now(), Claim.ClaimStatus.RECEIVED),
            new Claim("C002", "Ben", Claim.ClaimType.PROPERTY, 2000, LocalDate.now(), Claim.ClaimStatus.APPROVED)
        );
        assertEquals(3000, service.calculateTotalAmount(claims));
    }

    @Test
    void findsHighRiskClaims() {
        List<Claim> claims = List.of(new Claim("C003", "Mira", Claim.ClaimType.LIABILITY, 20000, LocalDate.now(), Claim.ClaimStatus.IN_REVIEW));
        assertFalse(service.getHighRiskClaims(claims).isEmpty());
    }
}

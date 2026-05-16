package com.example.claims;

import com.example.claims.model.Claim;
import com.example.claims.util.ClaimValidator;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClaimValidatorTest {
    private final ClaimValidator validator = new ClaimValidator();

    @Test
    void acceptsValidClaim() {
        Claim claim = new Claim("C001", "Anna Weber", Claim.ClaimType.ACCIDENT, 1200, LocalDate.now(), Claim.ClaimStatus.RECEIVED);
        assertTrue(validator.isValid(claim));
    }

    @Test
    void rejectsMissingId() {
        Claim claim = new Claim("", "Anna Weber", Claim.ClaimType.ACCIDENT, 1200, LocalDate.now(), Claim.ClaimStatus.RECEIVED);
        assertFalse(validator.isValid(claim));
    }

    @Test
    void rejectsNegativeAmount() {
        Claim claim = new Claim("C001", "Anna Weber", Claim.ClaimType.ACCIDENT, -1, LocalDate.now(), Claim.ClaimStatus.RECEIVED);
        assertFalse(validator.isValid(claim));
    }
}

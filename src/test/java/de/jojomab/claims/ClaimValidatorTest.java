package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.model.ClaimType;
import de.jojomab.claims.util.ClaimValidator;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClaimValidatorTest {

    private final ClaimValidator validator = new ClaimValidator();

    @Test
    void acceptsValidClaim() {
        Claim claim = new Claim("C300", "Test Person", ClaimType.PROPERTY, 2500.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);

        assertTrue(validator.isValid(claim));
    }

    @Test
    void rejectsBlankName() {
        Claim claim = new Claim("C301", "", ClaimType.PROPERTY, 2500.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);

        assertFalse(validator.isValid(claim));
    }

    @Test
    void rejectsInvalidAmount() {
        Claim claim = new Claim("C302", "Test Person", ClaimType.PROPERTY, 0.00, LocalDate.now(), ClaimStatus.RECEIVED, 0);

        assertFalse(validator.isValid(claim));
    }
}

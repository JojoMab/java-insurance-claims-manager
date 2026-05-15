package de.jojomab.claims.util;

import de.jojomab.claims.model.Claim;

public class ClaimValidator {

    public boolean isValid(Claim claim) {
        return hasRequiredFields(claim) && hasValidAmount(claim);
    }

    public boolean hasRequiredFields(Claim claim) {
        return claim != null
                && claim.getId() != null && !claim.getId().isBlank()
                && claim.getClaimantName() != null && !claim.getClaimantName().isBlank()
                && claim.getClaimType() != null
                && claim.getDate() != null
                && claim.getStatus() != null;
    }

    public boolean hasValidAmount(Claim claim) {
        return claim != null && claim.getAmount() > 0;
    }
}

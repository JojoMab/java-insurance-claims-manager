package com.example.claims.util;

import com.example.claims.model.Claim;

public class ClaimValidator {
    public boolean isValid(Claim claim) {
        return claim != null
            && claim.getId() != null && !claim.getId().isBlank()
            && claim.getClaimantName() != null && !claim.getClaimantName().isBlank()
            && claim.getClaimType() != null
            && claim.getStatus() != null
            && claim.getDate() != null
            && claim.getAmount() > 0;
    }
}

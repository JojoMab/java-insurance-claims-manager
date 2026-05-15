package de.jojomab.claims.service;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimType;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RiskScorer {

    public int score(Claim claim) {
        int score = 1;

        if (claim.getAmount() > 10000) {
            score += 4;
        } else if (claim.getAmount() > 5000) {
            score += 2;
        }

        if (claim.getClaimType() == ClaimType.LIABILITY) {
            score += 3;
        } else if (claim.getClaimType() == ClaimType.ACCIDENT) {
            score += 2;
        }

        long claimAgeDays = ChronoUnit.DAYS.between(claim.getDate(), LocalDate.now());
        if (claimAgeDays <= 30) {
            score += 2;
        }

        return Math.min(score, 10);
    }

    public String priority(Claim claim) {
        int score = score(claim);
        if (score >= 8) {
            return "high";
        }
        if (score >= 5) {
            return "medium";
        }
        return "low";
    }
}

package de.jojomab.claims.model;

import java.time.LocalDate;

public class Claim {
    private final String id;
    private final String claimantName;
    private final ClaimType claimType;
    private final double amount;
    private final LocalDate date;
    private final ClaimStatus status;
    private final int riskScore;

    public Claim(String id, String claimantName, ClaimType claimType, double amount, LocalDate date, ClaimStatus status, int riskScore) {
        this.id = id;
        this.claimantName = claimantName;
        this.claimType = claimType;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.riskScore = riskScore;
    }

    public String getId() {
        return id;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public ClaimType getClaimType() {
        return claimType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public int getRiskScore() {
        return riskScore;
    }
}

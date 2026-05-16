package com.example.claims.model;

import java.time.LocalDate;

public class Claim {
    public enum ClaimType { ACCIDENT, HEALTH, PROPERTY, LIABILITY }
    public enum ClaimStatus { RECEIVED, IN_REVIEW, APPROVED, REJECTED }

    private final String id;
    private final String claimantName;
    private final ClaimType claimType;
    private final double amount;
    private final LocalDate date;
    private final ClaimStatus status;
    private int riskScore;

    public Claim(String id, String claimantName, ClaimType claimType, double amount, LocalDate date, ClaimStatus status) {
        this.id = id;
        this.claimantName = claimantName;
        this.claimType = claimType;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getId() { return id; }
    public String getClaimantName() { return claimantName; }
    public ClaimType getClaimType() { return claimType; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public ClaimStatus getStatus() { return status; }
    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }
}

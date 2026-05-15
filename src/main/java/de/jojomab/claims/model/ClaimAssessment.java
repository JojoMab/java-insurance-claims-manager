package de.jojomab.claims.model;

public class ClaimAssessment {
    private final Claim claim;
    private final int riskScore;
    private final String priority;
    private final boolean plausible;

    public ClaimAssessment(Claim claim, int riskScore, String priority, boolean plausible) {
        this.claim = claim;
        this.riskScore = riskScore;
        this.priority = priority;
        this.plausible = plausible;
    }

    public Claim getClaim() { return claim; }
    public int getRiskScore() { return riskScore; }
    public String getPriority() { return priority; }
    public boolean isPlausible() { return plausible; }
}

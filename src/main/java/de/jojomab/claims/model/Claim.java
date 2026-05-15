package de.jojomab.claims.model;

public class Claim {
    private final String id;
    private final String type;
    private final double amount;
    private final int customerYears;
    private final ClaimStatus status;

    public Claim(String id, String type, double amount, int customerYears, ClaimStatus status) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.customerYears = customerYears;
        this.status = status;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public int getCustomerYears() { return customerYears; }
    public ClaimStatus getStatus() { return status; }
}

package Contracts;

public class LeaseContract extends Contract {

    private static final double ENDING_VALUE_RATE = 0.50;
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double LEASE_INTEREST_RATE = 0.04;
    private static final int LEASE_TERM_MONTHS = 36;
    private double price;
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, double price, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.price = price;
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;

        setTotalPrice();
        setMonthlyPayment();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.expectedEndingValue = price * ENDING_VALUE_RATE;
        this.leaseFee = price * LEASE_FEE_RATE;
        setTotalPrice();
        setMonthlyPayment();
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public void setTotalPrice() {
        this.totalPrice = price + leaseFee;
    }

    @Override
    public void setMonthlyPayment() {

        double loanAmount = price - expectedEndingValue;
        double monthlyRate = LEASE_INTEREST_RATE / 12.0;
        int months = LEASE_TERM_MONTHS;

        double numerator = loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months);
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        this.monthlyPayment = numerator / denominator;
    }
}

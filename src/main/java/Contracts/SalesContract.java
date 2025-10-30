package Contracts;

public class SalesContract extends Contract {

    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private double price, salesTaxAmount, recordingFee, processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double price, boolean isFinanced) {

        super(date, customerName, customerEmail, vehicleSold, 0.0, 0.0);

        this.price = price;
        this.isFinanced = isFinanced;
        this.salesTaxAmount = price * SALES_TAX_RATE;
        this.recordingFee = RECORDING_FEE;
        this.processingFee = (price < 10000) ? 295.0 : 495.0;

    }
    public void setPrice(double price) {
        this.price = price;
        this.salesTaxAmount = price * SALES_TAX_RATE;
        this.processingFee = (price < 10000) ? 295.0 : 495.0;
        setTotalPrice();
        setMonthlyPayment();
    }

    @Override
    public void setTotalPrice() {
        this.totalPrice = price + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public void setMonthlyPayment() {
        if (!isFinanced) {
            this.monthlyPayment = 0.0;
            return;
        }

        double loanAmount = this.totalPrice;
        double annualRate;
        int months;

        if (price >= 10000) {
            annualRate = 0.0425;
            months = 48;
        } else {
            annualRate = 0.0525;
            months = 24;
        }

        double monthlyRate = annualRate / 12.0;
        double numerator = loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months);
        double denominator = Math.pow(1 + monthlyRate, months) - 1;
        this.monthlyPayment = numerator / denominator;
    }

}
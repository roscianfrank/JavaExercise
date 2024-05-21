package excercise;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private double amount;
    private String currency;
    private String provider;

    public Payment(double amount, String currency, String provider) {
        this.amount = amount;
        this.currency = currency;
        this.provider = provider;
    }

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public static class PaymentDatabase {
        private List<Payment> payments;

        public PaymentDatabase() {
            this.payments = new ArrayList<>();
        }

        public void addPayment(Payment payment) {
            payments.add(payment);
        }

        public List<Payment> getPaymentsByProvider(String provider) {
            List<Payment> providerPayments = new ArrayList<>();
            for (Payment payment : payments) {
                if (payment.getProvider().equals(provider)) {
                    providerPayments.add(payment);
                }
            }
            return providerPayments;
        }

        // Additional methods as needed
    }
    public static void main(String[] args) {
        // Instantiate the payment database
        PaymentDatabase paymentDB = new PaymentDatabase();

        // Add payments
        paymentDB.addPayment(new Payment(100, "USD", "PayPal"));
        paymentDB.addPayment(new Payment(50, "EUR", "Stripe"));
        paymentDB.addPayment(new Payment(75, "USD", "PayPal"));
        paymentDB.addPayment(new Payment(200, "GBP", "Stripe"));

        // Retrieve payments by provider
        List<Payment> paypalPayments = paymentDB.getPaymentsByProvider("PayPal");
        System.out.println("Payments made through PayPal:");
        for (Payment payment : paypalPayments) {
            System.out.println("Amount: " + payment.getAmount() + " " + payment.getCurrency());
        }

        // Additional functionality can be added as needed
    }
}


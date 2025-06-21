package Week1_DesignPrinciplesAndPatterns.Exercise8_StrategyPattern.Code;

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    private final String CardNum;

    public CreditCardPayment(String CardNum){
        this.CardNum = CardNum;
    }
    public void pay(double amount) {
        System.out.println("Paid :"+ amount + " using the Credit Card "+ CardNum);
    }
}


class PayPalPayment implements PaymentStrategy{
    private final String email;
    public  PayPalPayment(String email){
        this.email = email;
    }
    public void pay(double amount) {
        System.out.println("Paid :"+ amount + " using the "+ email);
    }
}

class PaymentContext{
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void payAmount(double amount){
        if (strategy == null){
            System.out.println("Please select a payment Method.");
        }else{
            strategy.pay(amount);
        }
    }
}

class StrategyPatternExample{
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println();

        context.setPaymentStrategy(new CreditCardPayment("1234567890"));
        context.payAmount(10000);

        context.setPaymentStrategy(new PayPalPayment("user@paypal.com"));
        context.payAmount(20000);
    }
}
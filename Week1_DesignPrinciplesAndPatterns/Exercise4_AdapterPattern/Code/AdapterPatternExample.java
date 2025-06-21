package Week1_DesignPrinciplesAndPatterns.Exercise4_AdapterPattern.Code;

interface PaymentProcessor{
    void processPayment(double amnt);
}

class UPIgateway{
    public void pay(double amnt){
        System.out.println();
        System.out.println("Paid " + amnt + " using Gpay");
    }
}

class CardGateway{
    public void MakePayment(double amnt){
        System.out.println();
        System.out.println("Paid "+amnt+ " using Paytm");
    }
}

class UPIAdapter implements PaymentProcessor{
    private UPIgateway upi;

    public UPIAdapter(UPIgateway upi){
        this.upi = upi;
    }
    public void processPayment(double amnt) {
        upi.pay(amnt);
    }
}



class CardAdapter implements PaymentProcessor{
    private  CardGateway card;

    public CardAdapter(CardGateway card){
        this.card = card;
    }

    public void processPayment(double amnt) {
        card.MakePayment(amnt);
    }
}

class AdapterPatternExample{
    public static void main(String[] args) {

        PaymentProcessor UPI = new UPIAdapter(new UPIgateway());
        UPI.processPayment(1000.0);

        PaymentProcessor card = new CardAdapter(new CardGateway());
        card.processPayment(20000);

    }
}


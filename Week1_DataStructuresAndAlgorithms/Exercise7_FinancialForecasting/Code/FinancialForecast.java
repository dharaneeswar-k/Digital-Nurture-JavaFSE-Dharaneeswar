package Week1_DataStructuresAndAlgorithms.Exercise7_FinancialForecasting.Code;

public class FinancialForecast {

    public static double futureValue(double amount, double rate, int years) {
        if (years == 0) { //5
            return amount;
        }
        return futureValue(amount, rate, years - 1) * (1 + rate);
    }



    public static void main(String[] args) {
        double initialAmount = 10000.0;
        double annualRate = 0.10;
        int years = 5;

        double recursiveResult = futureValue(initialAmount, annualRate, years);
        System.out.println("Recursive Future Value after " + years + " years: ₹" + String.format("%.2f", recursiveResult));

    }
}


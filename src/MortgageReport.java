import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("================");

        int numberOfPayments = calculator.getNumberOfPayments();
        var remianingBalances = calculator.getRemaingBalances();
        for(double remainingBalance: remianingBalances) {
            System.out.println(currency.format(remainingBalance));
        }
    }

    public void printMortgage() {
        System.out.println("Mortgage");
        System.out.println("========");

        double mortgage = calculator.calculateMortgage();

        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }
}

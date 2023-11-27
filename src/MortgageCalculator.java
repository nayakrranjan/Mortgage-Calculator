import java.text.NumberFormat;

public class MortgageCalculator {

    final static byte monthsInYear = 12;
    final static byte percent = 100;

    private long loanAmount;
    private int period;
    private float annualInterest;

    public MortgageCalculator(long loanAmount, int period, float annualInterest) {
        this.loanAmount = loanAmount;
        this.period = period;
        this.annualInterest= annualInterest;
    }

    private float getMonthlyInterest () {
        return annualInterest/ percent/ monthsInYear;
    }
    public int getNumberOfPayments () {
        return period * monthsInYear;
    };

    public double calculateMortgage() {
        return loanAmount *
                (getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
    }

    public double[] getRemaingBalances () {
        var remainBalances = new double[getNumberOfPayments()];
        for (int numberOfPaymentsDone = 1; numberOfPaymentsDone <= remainBalances.length; numberOfPaymentsDone++) {
            remainBalances[numberOfPaymentsDone - 1] = calculateRemainBalance(numberOfPaymentsDone);
        }
        return remainBalances;
    }

    public double calculateRemainBalance(int numberOfPaymentsDone) {
        return loanAmount *
                (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsDone))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
    }
}

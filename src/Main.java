public class Main {

    public static void main(String[] args) {

        long loanAmount = (long) Console.getData("Principle: ", 100000, 10000000);
        float annualInterest = (float) Console.getData("Annual Interest Rate: ", 0.1, 30);
        short period = (short) Console.getData("Period(Years): ", 0.1, 15);


        var calculator = new MortgageCalculator(loanAmount, period, annualInterest);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
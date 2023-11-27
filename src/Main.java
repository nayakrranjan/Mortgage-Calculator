import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte percent = 100;
    final static byte monthsInYear = 12;

    public static void main(String[] args) {

        long loanAmount = (long) Main.getData("Principle: ", 99999, 10000000);
        float annualInterest = (float) Main.getData("Annual Interest Rate: ", 0, 30);
        short period = (short) Main.getData("Period(Years): ", 0, 15);

        int numberOfPayments = period * Main.monthsInYear;
        float monthlyInterest = annualInterest/ Main.percent/ Main.monthsInYear;
        double mortgage = Main.calculateMortgage(loanAmount, monthlyInterest, numberOfPayments);


            printMortgage(mortgage, loanAmount, monthlyInterest, numberOfPayments);
    }

    private static void printMortgage(double mortgage, long loanAmount, float monthlyInterest, int numberOfPayments) {
        System.out.println("Mortgage");
        System.out.println("========");
        System.out.println();
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("================");
        for(int numberOfPaymentsDone = 0; numberOfPaymentsDone <= numberOfPayments; numberOfPaymentsDone++) {
            Main.printPaymentSchedule(loanAmount, monthlyInterest, numberOfPayments, numberOfPaymentsDone);
        }
    }

    public static double getData(String prompt, int minValue, int maxValue) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            double returnValue = scanner.nextDouble();
            if (returnValue > minValue && returnValue <= maxValue)
                return returnValue;
            System.out.println("Please Enter a amount between " + minValue + " and " + maxValue);
        }
    }

    public static double calculateMortgage (long loanAmount, float monthlyInterest, int numberOfPayments) {

        return loanAmount *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                /(Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static void printPaymentSchedule(double loanAmount, float monthlyInterest, int numberOfPayments, int numberOfPaymentsDone) {

            double remainingAmount = loanAmount *
                    (Math.pow( 1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsDone))
                                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

            System.out.println(NumberFormat.getCurrencyInstance().format(remainingAmount));
    }
}
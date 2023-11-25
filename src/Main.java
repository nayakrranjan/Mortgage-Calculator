import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        long loanAmount = (long) Main.getData("Principle: ", 100000, 10000000);
        float annualInterest = (float) Main.getData("Annual Interest Rate: ", 0, 30);
        short period = (short) Main.getData("Period(Years): ", 0, 15);

        Double mortgage = Main.calculateMortgage(loanAmount, annualInterest, period);

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
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

    public static double calculateMortgage (long loanAmount, float annualInterest, short period) {
        final byte percent = 100;
        final byte monthsInYear = 12;

        float monthlyInterest = annualInterest/ percent/ monthsInYear;
        int numberOfPayments = period * monthsInYear;

        return loanAmount *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                /(Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
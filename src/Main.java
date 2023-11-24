import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final byte percent = 100;
        final byte monthsInYear = 12;

        System.out.print("Principle: ");
        long loanAmount = sc.nextLong();
        System.out.print("Annual Interest Rate: ");
        float annualInterest = sc.nextFloat();
        System.out.print("Period(Years): ");
        byte period = sc.nextByte();

        float monthlyInterest = annualInterest/ percent/ monthsInYear;
        int numberOfPayments = period * monthsInYear;

        Double mortgage = loanAmount *
                            (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                                    /(Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


    }
}
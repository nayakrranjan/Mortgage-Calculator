import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final byte percent = 100;
        final byte monthsInYear = 12;
        long loanAmount = 0;
        float annualInterest = 0;
        byte period = 0;

        while (true) {
            System.out.print("Principle: ");
            loanAmount = sc.nextLong();
            if (loanAmount > 100000 && loanAmount <= 10000000)
                break;
            System.out.println("Please Enter a amount between 1L and 1C");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = sc.nextFloat();
            if( annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Please Enter a amount between 1 and 30");
        }
        while (true) {
            System.out.print("Period(Years): ");
            period = sc.nextByte();
            if( period > 0 && period <= 15)
                break;
            System.out.println("Please Enter a amount between 1 and 15");
        }

        float monthlyInterest = annualInterest/ percent/ monthsInYear;
        int numberOfPayments = period * monthsInYear;

        Double mortgage = loanAmount *
                            (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                                    /(Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


    }
}
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double getData(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static double getData(String prompt, double minValue, double maxValue) {
        while (true) {
            System.out.print(prompt);
            double returnValue = scanner.nextDouble();
            if (returnValue >= minValue && returnValue <= maxValue)
                return returnValue;
            System.out.println("Please Enter a amount between " + minValue + " and " + maxValue);
        }
    }
}

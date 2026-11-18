package mattresssales;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
      // Two-dimensional array: 3 products and 3 months.
        int[][] monthlySales = new int[3][3];
        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month "
                        + (month + 1) + " for " + productNames[product]
                        + " mattress: ");
                int value = input.nextInt();
                while (value < 0) {
                    System.out.print("Enter 0 or a positive number: ");
                    value = input.nextInt();
                }
                monthlySales[product][month] = value;
            }
            System.out.println();
        }
        Product product = new Product(productNames, monthlySales);
        PrintProduct printer = new PrintProduct();
        printer.PrintReport(product, productNames);
        input.close();
    }
}
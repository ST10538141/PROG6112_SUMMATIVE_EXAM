package com.mycompany.mattresssales;
import java.util.Scanner;
public class MattressSales {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        // Each row is a product. Each column is a month.
        int[][] monthlySales = new int[3][3];
        // Ask the user to enter sales for each product and month.
        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month "
                        + (month + 1) + " for " + productNames[product]
                        + " mattress: ");
                while (!input.hasNextInt() || input.hasNextInt()
                        && inputIntIsNegative(input)) {
                    System.out.println("Please enter a whole number 0 or higher.");
                    System.out.print("Enter number of sales for month "
                            + (month + 1) + " for " + productNames[product]
                            + " mattress: ");
                }
                monthlySales[product][month] = input.nextInt();
            }
            System.out.println();
        }
        Product product = new Product(productNames, monthlySales);
        PrintProduct printer = new PrintProduct();
        printer.PrintReport(product, productNames);
        input.close();
    }
    // Read and reject negative whole numbers.
    private static boolean inputIntIsNegative(Scanner input) {
        return input.nextInt() < 0;
    }
}
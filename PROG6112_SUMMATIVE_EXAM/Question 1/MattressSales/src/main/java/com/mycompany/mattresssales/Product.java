package com.mycompany.mattresssales;


import mattresssales.*;
import mattresssales.IProduct;

public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] monthlySales;
    // The constructor receives product names and their monthly sales.
    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }
    // Add all monthly sales for all products.
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int row = 0; row < monthlySales.length; row++) {
            for (int column = 0; column < monthlySales[row].length; column++) {
                total += monthlySales[row][column];
     }
        }
        return total;
    }
    // There are 3 products and 3 months, giving 9 sales entries.
    @Override
    public double GetAverageProductSold() {
        int numberOfEntries = 0;
        for (int row = 0; row < monthlySales.length; row++) {
            numberOfEntries += monthlySales[row].length;
        }
        if (numberOfEntries == 0) {
            return 0.0;
        }
        return (double) GetTotalProductsSold() / numberOfEntries;
    }
    // Find the product with the greatest total across all three months.
    @Override
    public String GetMostPopularProduct() {
        int[] productTotals = new int[monthlySales.length];
        for (int row = 0; row < monthlySales.length; row++) {
            for (int column = 0; column < monthlySales[row].length; column++) {
                productTotals[row] += monthlySales[row][column];
            }
        }
        int highestIndex = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[highestIndex]) {
                highestIndex = i;
            }
        }
        return productNames[highestIndex];
    }
    // Return the total for one product. Used by the report printer.
    public int GetProductTotal(int productIndex) {
        int total = 0;
        for (int sale : monthlySales[productIndex]) {
            total += sale;
        }
        return total;
    }
}
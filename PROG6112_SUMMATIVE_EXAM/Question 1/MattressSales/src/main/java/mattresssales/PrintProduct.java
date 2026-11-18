package mattresssales;
public class PrintProduct {
    public void PrintTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: "
                + product.GetTotalProductsSold());
    }
    public void PrintAverageProductSales(Product product) {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n",
                product.GetAverageProductSold());
    }
    public void PrintMostPopularProduct(Product product,
                                        String[] productNames) {
        String popular = product.GetMostPopularProduct();
        // Find the total belonging to the popular product.
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equals(popular)) {
                System.out.println("MOST POPULAR PRODUCT: "
                        + popular + " (" + product.GetProductTotal(i) + ")");
                break;
             }
        }
    }
    public void PrintReport(Product product, String[] productNames) {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("***************************************");
        PrintTotalProductSales(product);
        PrintAverageProductSales(product);
        PrintMostPopularProduct(product, productNames);
    }
}

package mattresssales;

//import mattresssales.Product;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    //Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);

        assertEquals(153, product.GetTotalProductsSold());
    }

    //Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);

        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }

    //Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);

        assertEquals("Cozy Nights Monarch",
                     product.GetMostPopularProduct());
    }

    private void assertEquals(String cozy_Nights_Monarch, String GetMostPopularProduct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(double d, double GetAverageProductSold, double d0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int i, int GetTotalProductsSold) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
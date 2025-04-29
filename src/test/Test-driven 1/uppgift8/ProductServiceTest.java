package uppgift8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testTotalPriceWithTwoProducts() {
        ProductService service = new ProductService();
        service.addProduct(new Product("Bok", 150));
        service.addProduct(new Product("Penna", 50));

        double total = service.getTotalPrice();
        assertEquals(200, total, 0.001);
    }

    @Test
    public void testTotalPriceWithNoProducts() {
        ProductService service = new ProductService();
        assertEquals(0, service.getTotalPrice(), 0.001);
    }

    @Test
    public void testTotalPriceWithDiscount() {
        ProductService service = new ProductService();
        service.addProduct(new Product("Laptop", 10000));
        service.addProduct(new Product("Mus", 500));

        double totalWith10Percent = service.getTotalPriceWithDiscount(10); // 10% rabatt
        assertEquals(9450, totalWith10Percent, 0.001);
    }
}

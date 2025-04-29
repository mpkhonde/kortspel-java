package uppgift8;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // Lägg till en produkt
    public void addProduct(Product product) {
        products.add(product);
    }

    // Beräkna totalsumman
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Beräkna totalpris med rabatt (i procent, t.ex. 10 för 10%)
    public double getTotalPriceWithDiscount(double discountPercent) {
        double total = getTotalPrice();
        return total * (1 - discountPercent / 100);
    }

    // Hämta alla produkter
    public List<Product> getProducts() {
        return products;
    }
}

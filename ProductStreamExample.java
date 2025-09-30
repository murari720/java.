import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " (" + category + ") - " + price;
    }
}

public class ProductStreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 80000, "Electronics"),
                new Product("Phone", 60000, "Electronics"),
                new Product("Shirt", 2000, "Clothing"),
                new Product("Jeans", 3000, "Clothing"),
                new Product("Fridge", 50000, "Appliances"),
                new Product("Microwave", 15000, "Appliances")
        );

        // Group by Category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category:");
        productsByCategory.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        // Most expensive product in each category
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(groupingBy(p -> p.category,
                        maxBy(Comparator.comparingDouble(p -> p.price))));
        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensive.forEach((cat, prod) -> {
            System.out.println(cat + " -> " + prod.get());
        });

        // Average price of all products
        double avgPrice = products.stream()
                .collect(averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("Mouse", "Electronics", 25),
                new Product("Keyboard", "Electronics", 75),
                new Product("T-Shirt", "Clothing", 20),
                new Product("Jeans", "Clothing", 50),
                new Product("Novel", "Books", 15)
        );

        // 1. Get all unique product categories using a Set.
        Set<String> categories = products.stream()
                .map(Product::category)
                .collect(Collectors.toSet());

        System.out.println("=== Product Categories ===");
        System.out.println(categories);

        // 2. Find products that cost more than 30.
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.price() > 30)
                .toList();

        System.out.println("\n=== Products Over $30 ===");
        expensiveProducts.forEach(System.out::println);

        // 3. Get product names in uppercase.
        List<String> productNames = products.stream()
                .map(Product::name)
                .map(String::toUpperCase)
                .toList();

        System.out.println("\n=== Product Names ===");
        System.out.println(productNames);

        // 4. Calculate the total price of all products.
        double totalPrice = products.stream()
                .map(Product::price)
                .reduce(0.0, Double::sum);

        System.out.println("\n=== Total Price ===");
        System.out.println("$" + totalPrice);

        // 5. Sort products from cheapest to most expensive.
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::price))
                .toList();

        System.out.println("\n=== Products Sorted by Price ===");
        sortedProducts.forEach(System.out::println);

        // 6. Group products by category.
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category));

        System.out.println("\n=== Products Grouped by Category ===");
        productsByCategory.forEach((category, items) ->
                System.out.println(category + ": " + items)
        );

        // 7. Count how many products belong to each category.
        Map<String, Long> productCounts = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.counting()
                ));

        System.out.println("\n=== Product Count by Category ===");
        System.out.println(productCounts);
    }
}

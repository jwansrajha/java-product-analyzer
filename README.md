# Product Analyzer

A small Java project demonstrating Collections and the Stream API.

## Concepts demonstrated

- `List` to store products
- `Set` to collect unique categories
- `Map` to group products and count products by category
- `filter()` to find products above a price
- `map()` to transform product data
- `reduce()` to calculate the total price
- `sorted()` to sort products by price
- `collect()` and `Collectors.groupingBy()` to group data
- Method references such as `Product::category` and `System.out::println`

## Requirements

- Java 16 or newer

## How to run

From the folder containing `Main.java`:

```bash
javac Main.java
java Main
```

## Example

The program prints unique categories, products over $30, uppercase product names,
the total price, products sorted by price, products grouped by category, and the
number of products in each category.

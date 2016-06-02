package factory;

import factory.common.Product;
import factory.common.ProductA;
import factory.common.ProductB;
import factory.common.ProductC;

// adjusted from:
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/FactoryMain.java
public class FactoryOld {

    public static void main(String[] args) {

        Product product = ProductFactory.create("A");
        System.out.println(product);

        // nice, a factory, BUT let's say we want to enable ProductFactory to create the product FutureProduct.
        // This type is not in the switch case. Switch case is not extensible without modifying the ProductFactory code.
        // This is a violation of the Open Closed Principle.

        // Task: Refactor the factory so it can be extended by new types of products without having to modify its code.
        // (= Open Closed Principle)

        // Hint: use a Map<String, java.util.function.Supplier<Product>> instead of the switch case
        // and allow adding new suppliers from outside.

    }

    private static class ProductFactory {
        public static Product create(String name) {
            switch (name) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                throw new RuntimeException("No such product " + name);
            }
        }
    }

}
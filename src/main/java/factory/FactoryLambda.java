package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import factory.common.FutureProduct;
import factory.common.Product;
import factory.common.ProductA;
import factory.common.ProductB;
import factory.common.ProductC;

public class FactoryLambda {

    // adjusted from:
    // https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/FactoryMain.java
    public static void main(String[] args) {

        System.out.println(ProductFactory.create("A"));
        System.out.println(ProductFactory.create("B"));

        // not existing product throws exception
        try {
            ProductFactory.create("futureProduct");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // but now we can add new suppliers without modifying the factory code (just add a new supplier to the map).
        // yes we could do this before java 8 too, but an anonymous class would be needed for each supplier, even if it
        // is as simple as the ones shown
        ProductFactory.addSupplier("futureProduct", FutureProduct::new);
        System.out.println(ProductFactory.create("futureProduct"));

    }

    private static class ProductFactory {

        private static final Map<String, Supplier<Product>> map = new HashMap<>();

        static {
            map.put("A", ProductA::new);
            map.put("B", ProductB::new);
            map.put("C", ProductC::new);
        }

        public static Product create(String name) {
            Supplier<Product> p = map.get(name);
            if (p != null) {
                return p.get();
            } else {
                throw new RuntimeException("No such product " + name);
            }
        }

        public static void addSupplier(String key, Supplier<Product> supplier) {
            map.put(key, supplier);
        }

    }
}
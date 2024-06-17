package by.itstep.khmurovich.exam.model.data.container;

import by.itstep.khmurovich.exam.model.data.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCategory implements Iterable<Product> {
    private List<Product> products;

    public ProductCategory() {
        products = new ArrayList<>();
    }

    public ProductCategory(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("List of products:\n");
        for (Product product : products) {
            builder.append("\n").append(product);
        }
        return builder.toString();
    }
    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator();
    }


    private class ProductIterator implements Iterator<Product> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < products.size();
        }

        @Override
        public Product next() {
            Product product = products.get(currentIndex);
            currentIndex++;
            return product;
        }
    }
}

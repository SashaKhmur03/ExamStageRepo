package by.itstep.khmurovich.exam.dal;

import by.itstep.khmurovich.exam.model.data.Product;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO implements ProductInt{
    protected Connection connection;
    private List<Product> products;

    public AbstractDAO() {
        products = new ArrayList<>();
    }

    public abstract void connect();

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            System.out.println("Error while closing the connection: " + exception.getMessage());
        }
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void edit(int id, Product product) {
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public int getTotalProductCount() {
        return 0;
    }

    @Override
    public String getCheapestProduct() {
        return null;
    }

    @Override
    public String getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return "No products available";
        }

        double maxPrice = Double.MIN_VALUE;
        Product mostExpensiveProduct = null;

        for (Product product : products) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
                mostExpensiveProduct = product;
            }
        }

        return mostExpensiveProduct.getName();
    }
}

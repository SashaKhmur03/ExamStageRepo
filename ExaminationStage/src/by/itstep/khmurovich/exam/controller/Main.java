package by.itstep.khmurovich.exam.controller;

import by.itstep.khmurovich.exam.dal.ProductDAO;
import by.itstep.khmurovich.exam.model.data.Product;
import by.itstep.khmurovich.exam.model.data.container.ProductCategory;
import by.itstep.khmurovich.exam.model.logic.ProductManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static by.itstep.khmurovich.exam.model.logic.ProductManager.findCheapestProduct;
import static by.itstep.khmurovich.exam.model.logic.ProductManager.findMostExpensiveProduct;

public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        ProductCategory productCategory = productDAO.getAll();

        System.out.println(productCategory);
        //productDAO.remove(2);
       // productDAO.add(product1);

        int totalCount = productDAO.getTotalProductCount();
        System.out.println("number of product names: " + totalCount);

        String cheapestProduct = productDAO.getCheapestProduct();
        System.out.println("Cheapest product is " + cheapestProduct);

        String mostExpensiveProduct = productDAO.getMostExpensiveProduct();
        System.out.println("Most expensive product is " + mostExpensiveProduct);


//        int totalCount = ProductManager.findTotalProductCount(productCategory);
//        System.out.println("the total number of product names: " + totalCount);
//
//        Product cheapestProduct = findCheapestProduct(productCategory);
//        if (cheapestProduct != null) {
//            System.out.println("The most cheapest product: " + cheapestProduct.getName() + " - price: " + cheapestProduct.getPrice());
//        } else {
//            System.out.println("The list of products is empty");
//        }
//
//        Product mostExpensiveProduct = findMostExpensiveProduct(productCategory);
//        if (mostExpensiveProduct != null) {
//            System.out.println("The product with the highest price: " + mostExpensiveProduct.getName() + " - price: " + mostExpensiveProduct.getPrice());
//        } else {
//            System.out.println("The list of products is empty");
//        }
    }
}

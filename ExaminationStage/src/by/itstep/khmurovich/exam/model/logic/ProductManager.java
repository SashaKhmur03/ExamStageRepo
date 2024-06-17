package by.itstep.khmurovich.exam.model.logic;

import by.itstep.khmurovich.exam.model.data.Product;
import by.itstep.khmurovich.exam.model.data.container.ProductCategory;


public class ProductManager {

    public static int findTotalProductCount(ProductCategory productCategory) {
        int totalCount = 0;
        for (Product product : productCategory.getProducts()) {
            totalCount++;
        }

        return totalCount;
    }

    public static Product findCheapestProduct(ProductCategory productCategory) {
        Product cheapestProduct = null;

        for (Product product : productCategory.getProducts()) {
            if (cheapestProduct == null || product.getPrice() < cheapestProduct.getPrice()) {
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }

    public static Product findMostExpensiveProduct(ProductCategory productCategory) {
        Product mostExpensiveProduct = null;

        for (Product product : productCategory.getProducts()) {
            if (mostExpensiveProduct == null || product.getPrice() > mostExpensiveProduct.getPrice()) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

}

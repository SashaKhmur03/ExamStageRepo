package by.itstep.khmurovich.exam.dal;

import by.itstep.khmurovich.exam.model.data.Product;


public interface ProductInt {

    void add(Product product);

    void edit(int id, Product product);

    void remove(int id);

    int getTotalProductCount();

    String getCheapestProduct();

    String getMostExpensiveProduct();

}

package by.itstep.khmurovich.exam.dal;

import by.itstep.khmurovich.exam.model.data.Product;
import by.itstep.khmurovich.exam.model.data.container.ProductCategory;

import java.sql.*;


public class ProductDAO {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/product_db";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123qwe";
    public static final String GET_ALL_PRODUCT = "SELECT * FROM products ORDER BY name ";
    public static final String GET_COUNT_OF_NAME_PRODUCT = "SELECT COUNT(*) AS id_product FROM products";
    public static final String GET_CHEAPEST_PRODUCT = "SELECT * FROM products WHERE price = (SELECT MIN(price) FROM products) ";
    public static final String GET_MOST_EXPENSIVE_PRODUCT = "SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products) ";
    public static final String DELETE_PRODUCT = " DELETE FROM products WHERE id_product = ? ";
    public static final String ADD_PRODUCT = " INSERT INTO products(name, price) VALUES( ?, ?)  ";

    private Connection connection;

    public ProductDAO() {
        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }


    public ProductDAO(Connection connection) {
        this.connection = connection;
    }



    public void add(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void edit(int id, Product product) {
        remove(id);
        add(product);
    }

    public void remove(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public ProductCategory getAll() {
        ProductCategory productCategory = new ProductCategory();
        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_PRODUCT);

            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));

                productCategory.getProducts().add(product);
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return productCategory;
    }

    public int getTotalProductCount() {
        int totalCount = 0;
        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_COUNT_OF_NAME_PRODUCT);

            if (resultSet.next()) {
                totalCount = resultSet.getInt("id_product");
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return totalCount;
    }

    public String getCheapestProduct() {
        String cheapestProduct = "";
        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_CHEAPEST_PRODUCT);

            if (resultSet.next()) {
                cheapestProduct = resultSet.getString("name");
            }


        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return cheapestProduct;
    }

    public String getMostExpensiveProduct() {
        String mostExpensiveProduct = "";
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_MOST_EXPENSIVE_PRODUCT);

            if (resultSet.next()) {
                mostExpensiveProduct = resultSet.getString("name");
            }


        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return mostExpensiveProduct;
    }

    protected void finalize() throws Throwable {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }

}

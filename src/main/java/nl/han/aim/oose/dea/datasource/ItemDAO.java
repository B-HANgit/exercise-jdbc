package nl.han.aim.oose.dea.datasource;

import nl.han.aim.oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDAO {

    private String driver;
    private String connectionString;
    private Connection connection;

    public ItemDAO(String connectionString, String driver) {
        this.connectionString = connectionString;
        this.driver = driver;
    }

    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String sku = resultSet.getString("sku");
                String category = resultSet.getString("category");
                String title = resultSet.getString("title");
                items.add(new Item(sku, category, title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return items;
    }
}

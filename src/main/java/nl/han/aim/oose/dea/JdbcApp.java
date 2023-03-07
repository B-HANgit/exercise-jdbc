package nl.han.aim.oose.dea;

import nl.han.aim.oose.dea.datasource.ItemDAO;
import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.domain.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JdbcApp {

    public static void main(String[] args) throws IOException, SQLException {
        //TODO hoe test je DatabaseProperties?
        var dbprop = new DatabaseProperties();
        var driver = dbprop.getDriver();
        var connection = dbprop.getConnectionstring();
        System.out.println("Driver= "+driver);
        System.out.println("Connect= "+connection);

        try{
            var items = new ItemDAO(connection, driver);
            List<Item> allitems = items.findAll();
            for (Item item : allitems) {
                System.out.println(item);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

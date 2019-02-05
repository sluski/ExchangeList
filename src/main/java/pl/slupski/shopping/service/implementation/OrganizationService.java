package pl.slupski.shopping.service.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONObject;
import pl.slupski.shopping.service.enums.UnitTypeEnum;
import pl.slupski.shopping.service.interfaces.IOrganizationService;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
public class OrganizationService implements IOrganizationService {

    private final Random rand = new Random();
    private final String productsFile = System.getProperty("user.home") + "/files/products.json";
    private final String clientsFile = System.getProperty("user.home") + "/files/clients.json";
    private final String ordersFile = System.getProperty("user.home") + "/files/orders.json";

    @Override
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList();
//        for (int i = 0; i < 30; i++) {
//            result.add(new Product(generateRandomString(8)));
//        }
        return result;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> result = new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            result.add(new Client(generateRandomString(16), generateRandomString(25)));
//        }
        return result;
    }

    private String generateRandomString(int length) {
        String result = "";
        char[] args = "qwertyuiopasdfghjklzxcvbnm".toCharArray();

        for (int i = 0; i < length; i++) {
            result += args[rand.nextInt(args.length)];
        }
        return result;
    }

    private <T> T getRandomElement(List<T> t) {
        int size = t.size();
        return t.get(rand.nextInt(size));
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> result = new ArrayList();
        List<Client> clients = getAllClients();
        List<Product> products = getAllProducts();
        for (int i = 0; i < 50; i++) {
            result.add(new Order(getRandomElement(clients), getRandomElement(products), 2));
        }
        return result;
    }

    @Override
    public void insertProduct(Product product) {
        Map<String, Object> map = new HashMap();
        map.put("name", product.getName());
        writeJsonObject(productsFile, map);
    }

    @Override
    public void insertClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writeJsonObject(String path, Map map) {
        try {
            JSONObject jsonObj = new JSONObject(map);
            File fie = new File(path);
            if (fie.exists()) {
                Files.write(Paths.get(path), jsonObj.toString().getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(path), jsonObj.toString().getBytes());
            }

        } catch (IOException ex) {

        }

    }

}

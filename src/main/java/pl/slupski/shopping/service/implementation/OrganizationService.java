package pl.slupski.shopping.service.implementation;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import pl.slupski.shopping.service.interfaces.IOrganizationService;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
public class OrganizationService implements IOrganizationService {

    private final Gson gson = new Gson();
    private final String productsFile = System.getProperty("user.home") + "/files/products.json";
    private final String clientsFile = System.getProperty("user.home") + "/files/clients.json";
    private final String ordersFile = System.getProperty("user.home") + "/files/orders.json";

    @Override
    public List<Product> getAllProducts() throws IOException {

        return readJsonObjects(productsFile, Product[].class);
    }

    @Override
    public List<Client> getAllClients() throws IOException {
        return readJsonObjects(clientsFile, Client[].class);
    }

    @Override
    public List<Order> getAllOrders() throws IOException {
        return readJsonObjects(ordersFile, Order[].class);
    }

    private void writeJsonObjects(String path, List list) throws IOException {
        String jsonStr = gson.toJson(list);
        Files.write(Paths.get(path), jsonStr.getBytes());
    }

    private <T> List<T> readJsonObjects(String path, Class<T[]> clazz) throws IOException {
        T[] arr = new Gson().fromJson(Files.newBufferedReader(Paths.get(path)), clazz);
        return Arrays.asList(arr);
    }

    @Override
    public void saveProducts(List<Product> products) throws IOException {
        writeJsonObjects(productsFile, products);
    }

    @Override
    public void saveClients(List<Client> clients) throws IOException {
        writeJsonObjects(clientsFile, clients);
    }

    @Override
    public void saveOrders(List<Order> orders) throws IOException {
        writeJsonObjects(ordersFile, orders);
    }

}

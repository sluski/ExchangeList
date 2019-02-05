package pl.slupski.shopping.service.cache;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
@ManagedBean
@SessionScoped
public class DataCache {

    private static List<Order> orders;
    private static List<Product> products;
    private static List<Client> clients;

    public static void addToOrders(Order order) {
        if (orders != null) {
            orders.add(order);
        } else {
            orders = new ArrayList();
            orders.add(order);
        }

    }

    public static void addToProducts(Product product) {
        if (products != null) {
            products.add(product);
        } else {
            products = new ArrayList();
            products.add(product);
        }
    }

    public static void addToClients(Client client) {
        if (clients != null) {
            clients.add(client);
        } else {
            clients = new ArrayList();
            clients.add(client);
        }
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static List<Client> getClients() {
        return clients;
    }
}

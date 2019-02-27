package pl.slupski.shopping.service.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.slupski.shopping.service.implementation.OrganizationService;
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

    private static OrganizationService organizationService;

    public static void saveState() throws IOException {
        initIfIsNot();
        organizationService.saveClients(clients);
        organizationService.saveOrders(orders);
        organizationService.saveProducts(products);
    }

    public static void restoreState() throws IOException {
        initIfIsNot();
        orders = new ArrayList(organizationService.getAllOrders());
        products = new ArrayList(organizationService.getAllProducts());
        clients = new ArrayList(organizationService.getAllClients());
    }

    public static Product findProductByName(String name) {
        if (products != null) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    return product;
                }
            }
        }
        return null;
    }

    public static List<Order> findOrdersForClient(Client client) {
        List<Order> result = new ArrayList();
        orders.forEach(order -> {
            if (order.getClient().equals(client)) {
                result.add(order);
            }
        });
        return result;
    }

    public static Client findClientByName(String name) {
        if (clients != null) {
            for (Client client : clients) {
                if (client.getName().equals(name)) {
                    return client;
                }
            }
        }
        return null;
    }

    public static void clearState() {
        orders = new ArrayList();
        clients = new ArrayList();
        products = new ArrayList();
    }

    public static void clearOrders() {
        orders = new ArrayList();
    }

    public static void addToOrders(Order order) {
        initIfIsNot();
        orders.add(order);
    }

    public static void addToProducts(Product product) {
        initIfIsNot();
        products.add(product);
    }

    public static void addToClients(Client client) {
        initIfIsNot();
        clients.add(client);
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

    private static void initIfIsNot() {
        if (orders == null) {
            orders = new ArrayList();
        }
        if (clients == null) {
            clients = new ArrayList();
        }
        if (products == null) {
            products = new ArrayList();
        }
        if (organizationService == null) {
            organizationService = new OrganizationService();
        }
    }
}

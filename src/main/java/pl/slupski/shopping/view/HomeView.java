package pl.slupski.shopping.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.slupski.shopping.service.implementation.OrganizationService;
import pl.slupski.shopping.service.interfaces.IOrganizationService;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
@ManagedBean
@ViewScoped
public class HomeView {

    private List<Product> products;
    private List<Client> clients;
    private List<Order> orders;

    private final IOrganizationService organizationService;

    private Client newClient;
    private Order newOrder;
    private Product newProduct;

    public HomeView() {
        this.organizationService = new OrganizationService();
        newProduct = new Product();
        takeData();
    }

    public void onNewOrderAdd() {
        orders.add(newOrder);
    }

    public void onNewProductAdd() {
        products.add(newProduct);
        newProduct = new Product();
    }
    
    public void onNewClientAdd() {
        clients.add(newClient);
        newClient = new Client();
    }

    private void takeData() {
        products = organizationService.getAllProducts();
        clients = organizationService.getAllClients();
        orders = organizationService.getAllOrders();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public Client getNewClient() {
        return newClient;
    }

}

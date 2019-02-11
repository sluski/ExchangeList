package pl.slupski.shopping.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import pl.slupski.shopping.service.cache.DataCache;
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

    private Client newClient;
    private Order newOrder;
    private Product newProduct;
    
    public HomeView() {
        newProduct = new Product();
        newClient = new Client();
        newOrder = new Order();
    }

    public void saveState() {
        FacesMessage message;
        try {
            DataCache.saveState();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukces", "Zpisywanie zostało zakończone z powodzeniem.");
        } catch (IOException ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd krytyczny", "Błąd podczas zapisywania danych. Error message: " + ex.getMessage());
        }
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    public void clearOrders() {
        DataCache.clearOrders();
    }

    public void restore() {
        FacesMessage message;
        try {
            DataCache.restoreState();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukces", "Przywracanie zostało zakończone z powodzeniem.");

        } catch (IOException ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd krytyczny", "Błąd podczas przywracania danych. Error message: " + ex.getMessage());
        }
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public void onNewOrderAdd() {
        DataCache.addToOrders(newOrder);
        newOrder = new Order();
    }

    public void onNewProductAdd() {
        DataCache.addToProducts(newProduct);
        System.out.println("Produt added: " + newProduct.getName());
        newProduct = new Product();
    }

    public void onNewClientAdd() {
        DataCache.addToClients(newClient);
        System.out.println("Client added: " + newClient.getName());
        newClient = new Client();
    }

    public List<Client> completeClient(String query) {
        List<Client> result = new ArrayList();
        for (Client client : DataCache.getClients()) {
            if (client.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(client);
            }
        }
        return result;
    }

    public List<Product> completeProduct(String query) {
        List<Product> result = new ArrayList();
        for (Product product : DataCache.getProducts()) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProducts() {
        return DataCache.getProducts();
    }

    public List<Client> getClients() {
        return DataCache.getClients();
    }

    public List<Order> getOrders() {
        return DataCache.getOrders();
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

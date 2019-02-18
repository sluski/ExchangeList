package pl.slupski.shopping.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
@RequestScoped
public class HomeView {

    private Client newClient;
    private Order newOrder;
    private Product newProduct;
    private Order selectedOrder;

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
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Klient: ");
        strBuilder.append(newOrder.getClient().getName());
        strBuilder.append("\n Produkt: ");
        strBuilder.append(newOrder.getProduct().getName());
        strBuilder.append("\n Ilość: ");
        strBuilder.append(newOrder.getCount());
        growlMessage("Zamównienie zostało dodane", strBuilder.toString());
    }

    public void clearAll() {
        DataCache.clearState();
    }

    public void onNewProductAdd() {
        DataCache.addToProducts(newProduct);
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Produkt o nazwie ");
        strBuilder.append(newProduct.getName());
        strBuilder.append(" został dodany");
        growlMessage("Produkt został dodany", strBuilder.toString());
        newProduct = new Product();
    }

    public void onNewClientAdd() {
        DataCache.addToClients(newClient);
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Klient o nazwie ");
        strBuilder.append(newProduct.getName());
        strBuilder.append(" został dodany");
        growlMessage("Klient został dodany", strBuilder.toString());
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

    private void growlMessage(String header, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, message));
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

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

}

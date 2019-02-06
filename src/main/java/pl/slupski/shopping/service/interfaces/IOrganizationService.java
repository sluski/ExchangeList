package pl.slupski.shopping.service.interfaces;

import java.io.IOException;
import java.util.List;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
public interface IOrganizationService {
    
    List<Product> getAllProducts() throws IOException;
    
    List<Client> getAllClients() throws IOException;
    
    List<Order> getAllOrders() throws IOException;
    
    void saveProducts(List<Product> products)throws IOException;
    
    void saveClients(List<Client> clients)throws IOException;
    
    void saveOrders(List<Order> orders)throws IOException;
}

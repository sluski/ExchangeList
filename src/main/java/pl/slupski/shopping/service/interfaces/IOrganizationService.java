package pl.slupski.shopping.service.interfaces;

import java.util.List;
import pl.slupski.shopping.service.pojo.Client;
import pl.slupski.shopping.service.pojo.Order;
import pl.slupski.shopping.service.pojo.Product;

/**
 *
 * @author sluski
 */
public interface IOrganizationService {
    
    List<Product> getAllProducts();
    
    List<Client> getAllClients();
    
    List<Order> getAllOrders();
}

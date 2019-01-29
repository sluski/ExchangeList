package pl.slupski.shopping.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private Random rand = new Random();

    @Override
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList();
        for (int i = 0; i < 30; i++) {
            result.add(new Product(generateRandomString(8), UnitTypeEnum.KILOGRAM));
        }
        return result;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> result = new ArrayList();
        for (int i = 0; i < 10; i++) {
            result.add(new Client(generateRandomString(16), generateRandomString(25)));
        }
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
            result.add(new Order(getRandomElement(clients), getRandomElement(products)));
        }
        return result;
    }

}

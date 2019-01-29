package pl.slupski.shopping.service.pojo;

import lombok.Data;

/**
 *
 * @author sluski
 */
@Data
public class Order {

    private Client client;
    private Product product;

    public Order() {

    }

    public Order(Client client, Product product) {
        this.client = client;
        this.product = product;
    }

}

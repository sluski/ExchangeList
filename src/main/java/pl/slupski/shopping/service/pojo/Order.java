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
    private int count;

    public Order() {

    }

    public Order(Client client, Product product, int count) {
        this.client = client;
        this.product = product;
    }

}

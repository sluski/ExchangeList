package pl.slupski.shopping.service.pojo;


/**
 *
 * @author sluski
 */
public class Order {

    private Client client;
    private Product product;
    private int count;

    public Order() {
        client = new Client();
        product = new Product();
        count = 0;
    }

    public Order(Client client, Product product, int count) {
        this.client = client;
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    

}

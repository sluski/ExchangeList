package pl.slupski.shopping.service.pojo;


/**
 *
 * @author sluski
 */
public class Order {

    private Client client;
    private Product product;
    private String count;
    private boolean bought;

    public Order() {
        client = new Client();
        product = new Product();
        count = "";
    }

    public Order(Client client, Product product, String count, boolean bought) {
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}

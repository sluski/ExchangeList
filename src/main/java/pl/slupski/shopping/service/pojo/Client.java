package pl.slupski.shopping.service.pojo;

import lombok.Data;

/**
 *
 * @author sluski
 */
@Data
public class Client {

    private String name;
    private String location;

    public Client() {
        name = "";
        location = "";
    }

    public Client(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Client)) {
            return false;
        }
        Client c = (Client) o;
        if (c.getName().equals(this.name) && c.getLocation().equals(this.location)) {
            return true;
        }
        return false;
    }

}

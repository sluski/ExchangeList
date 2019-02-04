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
        
    }

    public Client(String name, String location) {
        this.name = name;
        this.location = location;
    }

}

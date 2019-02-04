package pl.slupski.shopping.service.pojo;

import lombok.Data;

/**
 *
 * @author sluski
 */
@Data
public class Product {

    private String name;

    public Product() {
        
    }

    public Product(String name) {
        this.name = name;
    }

}

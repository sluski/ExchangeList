package pl.slupski.shopping.service.pojo;

import lombok.Data;
import pl.slupski.shopping.service.enums.UnitTypeEnum;

/**
 *
 * @author sluski
 */
@Data
public class Product {

    private String name;
    private UnitTypeEnum unit;

    public Product() {
        
    }

    public Product(String name, UnitTypeEnum unit) {
        this.name = name;
        this.unit = unit;
    }

}

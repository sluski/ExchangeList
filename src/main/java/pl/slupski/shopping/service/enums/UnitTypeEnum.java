package pl.slupski.shopping.service.enums;

/**
 *
 * @author sluski
 */
public enum UnitTypeEnum {
    KILOGRAM(1),
    GRAM(2),
    LITER(3),
    MILILITER(4),
    METER(5),
    CENTIMETER(6);
    
    private int value;
    
    UnitTypeEnum(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

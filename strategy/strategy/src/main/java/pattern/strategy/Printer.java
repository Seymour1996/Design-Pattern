package pattern.strategy;

import lombok.Data;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/10/30 10:22
 * @github https://github.com/Seymour1996
 */
@Data
public class Printer {
    String name;
    String strategy;
    double discount;
    double price;
    double priceAfterDiscount;
}

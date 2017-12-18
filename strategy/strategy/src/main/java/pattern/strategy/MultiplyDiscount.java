package pattern.strategy;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/10/30 10:14
 * @github https://github.com/Seymour1996
 */
public class MultiplyDiscount implements PrinterDiscount {
    @Override
    public double calculatePrice(double price,double discount) {
        return price*discount;
    }
}

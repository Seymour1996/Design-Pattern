package pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/10/30 10:24
 * @github https://github.com/Seymour1996
 */
public class PrinterPriceCalculate {
    @Autowired
    PrinterDiscount printerDiscount;

    public void setPrintService(PrinterDiscount printerDiscount) {
        this.printerDiscount = printerDiscount;
    }
    public double getPrice(double price,double discount){
        return printerDiscount.calculatePrice(price,discount);
    }
}

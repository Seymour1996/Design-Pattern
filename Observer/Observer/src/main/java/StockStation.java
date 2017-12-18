/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/13 10:58
 * @github https://github.com/Seymour1996
 */

import java.util.Random;
public class StockStation {
    public static void main(String[] args) {

        final StockData stockData = new StockData();
        StockOne stockOne = new StockOne(stockData);
        final Random random = new Random();
        Thread thread = new Thread() {
            public void run() {
                double price = 15.00;
                while (price<15*1.1&&price>15*0.9) {
                    price = price + 0.2*(0.5 - random.nextDouble());
                    try {
                        stockData.setPrice(price);
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.run();

    }
}
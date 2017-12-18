/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/13 10:52
 * @github https://github.com/Seymour1996
 */
public class StockOne implements Observer {
    private double beginPrice;
    private double endPrice;
    private double lowPrice;
    private double highPrice;
    private double price;
    private Subject StockData;
    private DataWindow dataWindow;
    public StockOne(Subject StockData){
        beginPrice=15.00;
        endPrice=0;
        lowPrice=0;
        highPrice=0;
        this.StockData=StockData;
        dataWindow=new DataWindow();
        dataWindow.setVisible(true);
        StockData.registerObserver(this);
    }

    public void update(double price) {
        this.price=price;
        if(lowPrice==0){lowPrice=price;highPrice=price;}
        if(price<lowPrice)lowPrice=price;
        if(price>highPrice)highPrice=price;
        endPrice=price;
        display();
    }
    public void display(){
        long t = System.currentTimeMillis();
        dataWindow.addData(t,price,beginPrice,lowPrice,highPrice);
        if(price>beginPrice) {
            dataWindow.setPriceColor(true);
        }
        else
            dataWindow.setPriceColor(false);
        dataWindow.repaint();
    }
}

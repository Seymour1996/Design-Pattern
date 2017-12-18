import java.util.ArrayList;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/13 10:20
 * @github https://github.com/Seymour1996
 */
public class StockData implements Subject {
    private ArrayList<Observer> observers;
    private double price;

    public StockData(){
        observers=new ArrayList<Observer>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for(int i=0;i<observers.size();i++){
            Observer observer=(Observer)observers.get(i);
            observer.update(price);
        }
    }
    public void priceChanged(){
        notifyObservers();
    }
    public void setPrice(double price){
        this.price=price;
        priceChanged();
    }
}

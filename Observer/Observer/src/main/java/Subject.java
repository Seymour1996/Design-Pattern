/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/13 10:16
 * @github https://github.com/Seymour1996
 */

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

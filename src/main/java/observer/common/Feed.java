package observer.common;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String tweet) {
        for (Observer observer : observers) {
            observer.inform(tweet);
        }
    }
}

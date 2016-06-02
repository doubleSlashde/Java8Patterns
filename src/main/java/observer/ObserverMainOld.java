package observer;

import observer.common.Feed;
import observer.common.Observer;


// adjusted from: 
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/ObserverMain.java
public class ObserverMainOld {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("Money money money, give me money!");
        f.notifyObservers("Money money money, give me money queen!");
        f.notifyObservers("No more wine in town!");
        
        // Task: replace the observer classes below with lambdas

    }
   
    static private class NYTimes implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY!" + tweet);
            }
        }
    }

    static private class Guardian implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        }
    }

    static private class LeMonde implements Observer{
        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("wine")){
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }



}

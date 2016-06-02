package observer;

import observer.common.Feed;

public class ObserverMainLambda {

    // adjusted from:
    // https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/ObserverMain.java
    public static void main(String[] args) {

        Feed feedLambda = new Feed();

        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        feedLambda.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });

        feedLambda.notifyObservers("Money money money, give me money!");

        feedLambda.notifyObservers("Money money money, give me money queen!");

        feedLambda.notifyObservers(
                "The most expensive wine Domaine de la Romanee-Conti Romanee-Conti Grand Cru, Cote de Nuits, France sells for at least $13,007!");

    }

}

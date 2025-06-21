package Week1_DesignPrinciplesAndPatterns.Exercise7_ObserverPattern.Code;

import java.util.*;

interface Stock{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock{
    private final List<Observer> obvlist = new ArrayList<>();
    private double stockPrice;
    @Override
    public void registerObserver(Observer o) {
        obvlist.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        obvlist.remove(o);
    }

    public void notifyObservers() {
        for(Observer obv : obvlist){
            obv.update(stockPrice);
        }
    }

    public void setStockPrice(double price){
        this.stockPrice = price;
        System.out.println("\nStock price Updated to "+ price);
        notifyObservers();
    }
}

interface Observer{
    void update(double stockprice);
}

class WebApp implements Observer{
    private String name;

    public WebApp(String name){
        this.name = name;
    }
    @Override
    public void update(double stockprice) {
        System.out.println(name + " - Webapp Received update! Stock price is updated to"+ stockprice);
    }
}

class MobileApp implements Observer{

    private String name;

    public MobileApp(String name){
        this.name = name;
    }
    @Override
    public void update(double stockprice) {
        System.out.println(name + " - Mobileapp Received update! Stock price is updated to"+ stockprice);
    }
}



class ObserverPatternExample{
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        MobileApp mobileApp = new MobileApp("Dharaneeswar");
        WebApp webApp = new WebApp("Dharaneeswar");

        market.registerObserver(mobileApp);
        market.registerObserver(webApp);

        market.setStockPrice(100.50);
        market.setStockPrice(110.75);

        market.removeObserver(mobileApp);
        market.setStockPrice(111.11);
    }
}

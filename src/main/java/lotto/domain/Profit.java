package lotto.domain;

public class Profit {

    private long payment;
    private long price;

    public Profit(){
        price = 0;
    }

    public void checkPayment(long payment){
        this.payment = payment;
    }

    public void addPrice(long price){
        this.price += price;
    }

    public float getProfit(){return 0;}

}

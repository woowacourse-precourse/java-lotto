package lotto.domain;

public class Price {
    private static final int MIN_UNIT_NUMBER = 1000;
    private int price;
    private int trial;
    private float yield;

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTrial(){
        return this.trial;
    }

    public void setTrial(int price) {
        this.trial = price / MIN_UNIT_NUMBER;
    }
}

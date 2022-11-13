package lotto.domain;

public class Ticket {

    private final int PRICE = 1000;

    public int count(int money) {
        return money/PRICE;
    }
}

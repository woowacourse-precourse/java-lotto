package lotto;

public enum Winning {
    EqualThree(5000),
    EqualFour(50000),
    EqualFive(1500000),
    EqualFiveAndBonus(30000000),
    EqualSix(2000000000);

    private int cash;

    Winning(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }
}

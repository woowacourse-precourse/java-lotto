package lotto;

public class Money {
    private int won;

    public Money(String won) {
        this.won = Integer.parseInt(won);
    }

    public int moneyToAmount() {
        int amount;
        amount = this.won / 1000;
        return amount;

    }

    public int getMoney() {
        return won;
    }

    public void setMoney(int won) {
        this.won = won;
    }
}

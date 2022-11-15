package domain.user;

public class User {

    private int amount;
    private int count;
    private int yield;
    private Number number;

    public User(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}

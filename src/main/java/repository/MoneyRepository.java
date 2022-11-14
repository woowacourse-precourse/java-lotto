package repository;

public class MoneyRepository {
    private int money;

    public void save(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }
}

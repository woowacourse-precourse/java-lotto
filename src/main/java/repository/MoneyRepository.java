package repository;

public class MoneyRepository {
    private int money;
    private double rateOfReturn;

    public void save(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void saveRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
}

package lotto.commons;

public enum RankMoney {
    FIRST_WIN(2000000000),
    SECOND_WIN(30000000),
    THIRD_WIN(1500000),
    FIRTH_WIN(50000),
    FIFTH_WIN(5000);

    private long money;

    private RankMoney() {
    }

    private RankMoney(int money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }
}

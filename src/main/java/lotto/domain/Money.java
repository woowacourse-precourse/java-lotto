package lotto.domain;

public class Money {

    private long money;

    public Money(String money) {
        this.money = Long.parseLong(money);
        validate(this.money);
    }

    private void validate(long money) {
        if (money < 1000) {
            System.out.println(Message.MONEY_IS_LOWER_THAN_1000.get());
            throw new IllegalArgumentException();
        }
        if (money % 1000 != 0) {
            System.out.println(Message.MONEY_CANT_DIVIED_BY_1000.get());
            throw new IllegalArgumentException();
        }
    }

    public long getMoney() {
        return money;
    }

}

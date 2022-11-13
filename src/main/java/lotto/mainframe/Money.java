package lotto.mainframe;

import java.text.DecimalFormat;

public enum Money {

    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    public int money;

    Money(int money) {
        this.money = money;
    }

    public String getMoney() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }

    public int getMoneyAsInteger(){
        return money;
    }
}

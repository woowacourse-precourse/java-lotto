package model;

import constant.Config;

public class Lottos {
    private final int count;

    public Lottos(Money money) {
        this.count = money.getMoney() / Config.PRICE;
    }

    public int getCount() {
        return count;
    }
}
package lotto.utill;

import lotto.Messages.Message;

public enum Rank {
    FIRST(6, 2_000_000_000, Message.same_6),
    SECOND(5, 30_000_000, Message.same_5_and_bonus),
    THIRD(5, 1_500_000, Message.same_5),
    FOURTH(4, 50_000, Message.same_4),
    FIFTH(3, 5_000, Message.same_3),
    NONE(0, 0, "");

    private final int count;
    private final int money;
    private final String message;

    Rank(int count, int money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}

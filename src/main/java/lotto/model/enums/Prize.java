package lotto.model.enums;

public enum Prize {
    PRIZE_3(5000),
    PRIZE_4(50000),
    PRIZE_5(1500000),
    PRIZE_5BONUS(30000000),
    PRIZE_6(2000000000);

    private int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}

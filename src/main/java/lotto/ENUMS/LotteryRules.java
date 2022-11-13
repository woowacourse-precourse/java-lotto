package lotto.ENUMS;

public enum LotteryRules {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6);
    private int number;

    LotteryRules(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

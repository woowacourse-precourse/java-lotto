package lotto.domain;

public enum LotteryNumber {
    LOTTERY_PRICE(1_000),
    COUNT_OF_LOTTERY_NUMBERS(6),
    LOTTERY_MINIMUM_NUMBER(1),
    LOTTERY_MAXIMUM_NUMBER(45),
    MINIMUM_MATCH_NUMBER(3),
    FIVE_NUMBERS_MATCH(5),
    PERCENT(100);

    private int number;
    LotteryNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

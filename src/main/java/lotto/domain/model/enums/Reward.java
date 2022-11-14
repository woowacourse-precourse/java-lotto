package lotto.domain.model.enums;

public enum Reward {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int correctCount;
    private final long price;
    private final boolean hasBonusNumber;

    Reward(int correctCount, long price, boolean hasBonusNumber) {
        this.correctCount = correctCount;
        this.price = price;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getPrice() {
        return price;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

}

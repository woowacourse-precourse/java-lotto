package lotto.domain;

/**
 * 출력하고자 하는 순서대로 상수들을 선언해주셔야 올바른 순서로 출력됩니다.
 */
public enum Rank {
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치");

    final int winningPrice;
    final String descriptionMessage;

    Rank(int winningPrice, String descriptionMessage) {
        this.winningPrice = winningPrice;
        this.descriptionMessage = descriptionMessage;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public String getDescriptionMessage() {
        return descriptionMessage;
    }
}

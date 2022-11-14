package lotto.controller;

public enum CorrectNumber {
    THREE(3, "3개 일치 (5,000원) - "),
    FOUR(4, "4개 일치 (50,000원) - "),
    FIVE(5, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, "6개 일치 (2,000,000,000원) - ");

    private final int correctNumber;
    private final String cashPrize;

    CorrectNumber(int correctNumber, String cashPrize) {
        this.correctNumber = correctNumber;
        this.cashPrize = cashPrize;
    }
}

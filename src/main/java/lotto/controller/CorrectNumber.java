package lotto.controller;

public enum CorrectNumber {
    LESS_THAN_THREE(0, 0, "3개 미만 (0원) - ", 0),
    THREE(3, 5000, "3개 일치 (5,000원) - ", 0),
    FOUR(4, 50_000, "4개 일치 (50,000원) - ", 0),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - ", 0),
    FIVE_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", 0);

    private final int correctNumber;
    private final int cashPrize;
    private final String prizeInformationMent;
    private int numberOfCorrectType;

    public int getCorrectNumber() { return correctNumber; }
    public int getCashPrize() { return cashPrize; }
    public String getPrizeInformationMent() { return prizeInformationMent; }
    public int getNumberOfCorrectType() { return numberOfCorrectType; }

    public int addNumberOfCorrectType() {
        return numberOfCorrectType + 1;
    }

    CorrectNumber(int correctNumber, int cashPrize, String prizeInformationMent, int numberOfCorrectType) {
        this.correctNumber = correctNumber;
        this.cashPrize = cashPrize;
        this.prizeInformationMent = prizeInformationMent;
        this.numberOfCorrectType = numberOfCorrectType;
    }
}

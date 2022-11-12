package lotto.setting;

public enum WinningEnum {

    // 당첨 등수, 일치한 당첨 번호 개수, 보너스볼 일치 여부, 당첨 금액
    // 1등 당첨, 6개 일치, 보너스볼 불일치, 2,000,000,000원 수령
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000);

    private int rank;
    private int correctNumberCount;
    private boolean haveToCorrectBonusNumber;
    private int winningAmount;

    WinningEnum(int rank, int correctNumberCount, boolean haveToCorrectBonusNumber, int winningAmount) {
        this.rank = rank;
        this.correctNumberCount = correctNumberCount;
        this.haveToCorrectBonusNumber = haveToCorrectBonusNumber;
        this.winningAmount = winningAmount;
    }
}

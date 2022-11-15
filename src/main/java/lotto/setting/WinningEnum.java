package lotto.setting;

public enum WinningEnum {

    // 당첨 등수, 일치한 당첨 번호 개수, 보너스볼 일치 여부, 당첨 금액
    FIFTH(5, 3, false, 5000),
    FOURTH(4, 4, false, 50000),
    THIRD(3, 5, false, 1500000),
    SECOND(2, 5, true, 30000000),
    FIRST(1, 6, false, 2000000000);

    private final int rank;
    private final int correctNumberCount;
    private final boolean haveToCorrectBonusNumber;
    private final int winningAmount;


    WinningEnum(int rank, int correctNumberCount, boolean haveToCorrectBonusNumber, int winningAmount) {
        this.rank = rank;
        this.correctNumberCount = correctNumberCount;
        this.haveToCorrectBonusNumber = haveToCorrectBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static WinningEnum getWinning(int inputCorrect, boolean inputHaveToCorrect){
        for(WinningEnum winning : WinningEnum.values()){
            if(inputCorrect == winning.correctNumberCount && inputHaveToCorrect == winning.haveToCorrectBonusNumber){
                return winning;
            }
        }
        return null;
    }

    public int getCorrectNumberCount(){
        return this.correctNumberCount;
    }

    public boolean isHaveToCorrectBonusNumber(){
        return this.haveToCorrectBonusNumber;
    }

    public int getWinningAmount(){
        return this.winningAmount;
    }
}

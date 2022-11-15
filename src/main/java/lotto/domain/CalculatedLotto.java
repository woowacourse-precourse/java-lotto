package lotto.domain;

public class CalculatedLotto {
    private int winningLottoCount;
    private boolean isBonusNumberIncluded;

    public CalculatedLotto(){
        winningLottoCount = 0;
        isBonusNumberIncluded = false;
    }

    public void increaseWinningLottoCount(){
        winningLottoCount++;
    }

    public void switchToTrue(){
        isBonusNumberIncluded = true;
    }

    public int getWinningLottoCount() {
        return winningLottoCount;
    }

    public boolean isBonusNumberIncluded() {
        return isBonusNumberIncluded;
    }
}

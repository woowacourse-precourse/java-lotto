package lotto;

import java.util.List;

public class WinLotto {

    private int winLottoCount = 0;
    private static int bonusNumber = 0;
    private boolean isBonusNumber;

    public int getWinLottoCount() {
        return this.winLottoCount;
    }

    public void setWinLottoCount(int winLottoCount) {
        this.winLottoCount = winLottoCount;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean getIsBonusNumber() {
        return isBonusNumber;
    }

    public void setIsBonusNumber(boolean isBonusNumber) {
        this.isBonusNumber = isBonusNumber;
    }

}

package lotto;

import java.util.List;

public class WinLotto {

    private List<Integer> winLottoCount;
    private int bonusNumber = 0;

    public WinLotto(List<Integer> winLottoCount) {
        this.winLottoCount = winLottoCount;
    }

    public List<Integer> getWinLottoNumber() {
        return this.winLottoCount;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

}

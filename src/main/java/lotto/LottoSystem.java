package lotto;

import java.util.List;

public class LottoSystem {
    private List<Integer> winNumbers;
    private int bonusNumbers;

    public LottoSystem() {
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumbers(int bonusNumbers) {
        this.bonusNumbers = bonusNumbers;
    }
}

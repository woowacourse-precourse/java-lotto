package lotto;

import java.util.List;

public class WinningLotto extends LottoNumberMaker {

    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }
}

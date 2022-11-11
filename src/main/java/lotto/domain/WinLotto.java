package lotto.domain;

import lotto.validate.WinLottoValidate;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {
    private final List<Integer> winNumbers;

    public WinLotto(Lotto winLotto, int bonus) {
        validate(winLotto, bonus);
        winNumbers = new ArrayList<>(winLotto.getNumbers());
        winNumbers.add(bonus);
    }

    private void validate(Lotto winLotto, int bonus) {
        WinLottoValidate winLottoValidate = new WinLottoValidate();
    }
    public List<Integer> getWinNumbers(){
        return winNumbers;
    }

}

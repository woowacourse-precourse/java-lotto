package lotto.domain;

import lotto.validate.WinLottoValidate;

import java.util.List;

public class WinLotto {

    public WinLotto(Lotto winLotto, int bonus) {
        validate(winLotto, bonus);
    }

    private void validate(Lotto winLotto, int bonus) {
        WinLottoValidate winLottoValidate = new WinLottoValidate();
    }


}

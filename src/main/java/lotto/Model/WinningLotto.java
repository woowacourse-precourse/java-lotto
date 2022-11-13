package lotto.Model;

import java.util.List;
import lotto.Utils.Util;
import lotto.Utils.Validator.BonusValidator;
import lotto.Utils.Validator.WinningLottoValidator;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonus;

    public WinningLotto(String lotto, String bonus) {
        new WinningLottoValidator(lotto);
        List<Integer> WinningLotto = Util.getList(lotto);
        new BonusValidator(WinningLotto, bonus);

        this.winningNumbers = WinningLotto;
        this.bonus = Util.getInt(bonus);
    }
}

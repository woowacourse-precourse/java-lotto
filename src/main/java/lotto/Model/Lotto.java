package lotto.Model;

import java.util.List;
import lotto.Utils.Util;
import lotto.Utils.Validator.BonusValidator;
import lotto.Utils.Validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String lotto, String bonus) {
        new LottoValidator(lotto);
        List<Integer> WinningLotto = Util.getList(lotto);

        new BonusValidator(WinningLotto, bonus);
        WinningLotto.add(Util.getInt(bonus));

        this.numbers = WinningLotto;
    }

    // TODO: 추가 기능 구현
}

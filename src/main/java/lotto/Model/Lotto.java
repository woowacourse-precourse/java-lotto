package lotto.Model;

import java.util.List;
import lotto.Utils.Util;
import lotto.Utils.Validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String number) {
        new LottoValidator(number);
        this.numbers = Util.getList(number);
    }

    // TODO: 추가 기능 구현
}

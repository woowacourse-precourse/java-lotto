package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.IntConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue(), IntConstant.LOTTO_NUMBER_COUNT.getValue());
    }

    // TODO: 추가 기능 구현
}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Constants;

public class NumbersGenerator {

    public List<Integer> generatorNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER_RANGE.getValue(),
                Constants.MAX_LOTTO_NUMBER_RANGE.getValue(), Constants.LOTTO_NUMBERS_LENGTH.getValue());
    }

}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.START_NUMBER.getValue(),
                LottoConstants.END_NUMBER.getValue(),
                LottoConstants.LENGTH.getValue());
        return numbers;
    }
}

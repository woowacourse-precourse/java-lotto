package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.START_NUMBER,
                LottoConstants.END_NUMBER,
                LottoConstants.LENGTH);
        return numbers;
    }
}

package lotto.domain;

import static lotto.domain.LottoValidator.validateLottoNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validateLottoNumbers(numbers);
        return numbers;
    }
}

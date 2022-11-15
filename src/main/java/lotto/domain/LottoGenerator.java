package lotto.domain;

import static lotto.domain.LottoValidator.validateLottoNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted().collect(Collectors.toList());
        validateLottoNumbers(numbers);
        return numbers;
    }
}

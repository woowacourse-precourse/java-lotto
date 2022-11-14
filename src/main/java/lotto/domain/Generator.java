package lotto.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class Generator {

    Generator() {}

    List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.SIZE_OF_NUMBERS);
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}

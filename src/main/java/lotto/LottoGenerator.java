package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lotto generatorLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumbers(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}

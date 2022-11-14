package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static Lotto generatorLotto() {
        List<Integer> createdRandoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> randomNumbers = new ArrayList<>(createdRandoms);
        sortRandomNumbers(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private static void sortRandomNumbers(List<Integer> numbers) {
        numbers.sort((number1, number2) -> number1 - number2);
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static Lotto generatorLotto() {
        int minNumber = Rules.LOTTO_MIN_NUMBER.getValue();
        int maxNumber = Rules.LOTTO_MAX_NUMBER.getValue();
        int lottoSize = Rules.LOTTO_SIZE.getValue();
        List<Integer> createdRandoms = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoSize);
        List<Integer> randomNumbers = new ArrayList<>(createdRandoms);
        sortRandomNumbers(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private static void sortRandomNumbers(List<Integer> numbers) {
        numbers.sort((number1, number2) -> number1 - number2);
    }
}

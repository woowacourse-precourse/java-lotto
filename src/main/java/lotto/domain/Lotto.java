package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Validation.validateRange;
import static lotto.utils.ExceptionMessage.DUPLICATE_VALUE;
import static lotto.utils.Validation.validateSize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_VALUE.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

    public static List<Lotto> lottosGenerator(int num) {
        List<Lotto> lottos = new ArrayList<>();

        while (num != 0) {
            Lotto lotto = lottoGenerator();
            lottos.add(lotto);

            num--;
        }
        return lottos;
    }

    public static Lotto lottoGenerator() {
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_RANGE_START_NUM.getValue(),
                Constant.LOTTO_RANGE_END_NUM.getValue(),
                Constant.LOTTO_SIZE.getValue());

        List<Integer> lottoNums = randomNums.stream()
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lottoNums);
    }

    public static void printLotto(int num, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}

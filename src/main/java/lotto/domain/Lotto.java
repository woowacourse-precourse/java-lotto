package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.data.ErrorMessage;

import java.util.List;


public class Lotto {
    public static int lottoQuantity;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.RANDOM_SIZE_ERROR.getErrorLog());
        }
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException(ErrorMessage.RANDOM_DUPLICATE_ERROR.getErrorLog());
    }

    public static void buyLotto() {
        lottoQuantity = StartLotto.payment / 1000;
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            StartLotto.lotto.add(new Lotto(numbers));
        }
    }

    public List<Integer> getNums() {
        return numbers;
    }
}

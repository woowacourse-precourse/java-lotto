package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Constant.ErrorMessage;


public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    private void validate(List<Integer> numbers) {
        if (LottoNumberValidator.isNotSameSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE);
        }

        if (LottoNumberValidator.existDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_INPUT);
        }

        if (LottoNumberValidator.isOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

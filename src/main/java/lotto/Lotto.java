package lotto;

import static lotto.Constant.ErrorMessage.DUPLICATED_INPUT;
import static lotto.Constant.ErrorMessage.WRONG_RANGE;
import static lotto.Constant.ErrorMessage.WRONG_SIZE;

import static lotto.Constant.LottoValue.MAX_RANGE;
import static lotto.Constant.LottoValue.MIN_RANGE;
import static lotto.Constant.LottoValue.NUMBER_EA;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;



public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_EA);
        final Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    private void validate(List<Integer> numbers) {
        if (LottoNumberValidator.isNotSameSize(numbers)) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }

        if (LottoNumberValidator.existDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_INPUT);
        }

        if (LottoNumberValidator.isOutOfRange(numbers)) {
            throw new IllegalArgumentException(WRONG_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

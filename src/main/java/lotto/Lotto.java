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
            System.out.println(ErrorMessage.WRONG_SIZE);
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.existDuplicate(numbers)) {
            System.out.println(ErrorMessage.DUPLICATED_INPUT);
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.isOutOfRange(numbers)) {
            System.out.println(ErrorMessage.WRONG_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

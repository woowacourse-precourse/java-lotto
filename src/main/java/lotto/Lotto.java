package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;




public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (LottoNumberValidator.isNotSameSize(numbers)) {
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.existDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        if (LottoNumberValidator.isOutOfRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

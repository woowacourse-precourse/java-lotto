package lotto;

import java.util.List;
import lotto.util.InputVerifier;
import lotto.view.View;

/*
 * 로또의 1개 라인(6개의 숫자)을 의미하는 객체
 */

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!InputVerifier.isValidSize(numbers)) {
            View.printNotLottoSize();
            throw new IllegalArgumentException();
        }

        if (!InputVerifier.isValidNumbers(numbers)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }

        if (!InputVerifier.isUniqueNumber(numbers)) {
            View.printNotUniqueNumber();
            throw new IllegalArgumentException();
        }
    }

}

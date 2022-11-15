package lotto;

import java.util.List;
import lotto.util.Validator;
import lotto.view.View;

/*
 * 로또의 1개 라인(6개의 숫자)을 의미하는 객체
 */

public class Lotto {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    public static int getStartNumber() {
        return START_NUMBER;
    }

    public static int getEndNumber() {
        return END_NUMBER;
    }

    public static int getSize() {
        return SIZE;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            View.printNotLottoSize(SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (!Validator.isUniqueNumber(numbers)) {
            View.printNotUniqueNumber();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(int number) {
        if (!(number >= START_NUMBER && number <= END_NUMBER)) {
            View.printNotLottoNumber(START_NUMBER, END_NUMBER);
            throw new IllegalArgumentException();
        }
    }

}

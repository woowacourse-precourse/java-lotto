package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

public class Lotto {
    private static final int PROPER_QUANTITY = 6;
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";
    private static final String WRONG_QUANTITY_ERROR_MESSAGE = "[ERROR] 로또 번호의 수가 6개가 아닙니다. 프로그램을 종료합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validateProperQuantity(numbers);
        Validation.validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean has(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }
}

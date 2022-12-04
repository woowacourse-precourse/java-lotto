package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없어요.";
    private static final String LOTTO_RANGE_ERROR = "[ERROR] 로또 번호는 1 ~ 45만 입력 가능해요.";
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 중복되지 않는 6 수를 입력해 주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public int count(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::checkContains)
                .count();
    }

    protected boolean checkContains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        for (Integer number : numbers) {
            checkDuplicateNumber(numbers, number);
            checkLottoRange(number);
        }
    }

    private static void checkDuplicateNumber(List<Integer> numbers, Integer number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    protected void checkLottoRange(Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR);
        }
    }

    private static void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}

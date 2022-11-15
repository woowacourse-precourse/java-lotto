package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;

    public static final String NUMBER_INPUT_COUNT_ERROR_MESSAGE =
            "[ERROR] 로또 번호는 중복되지 않는 " + NUMBER_COUNT + "개의 숫자여야 합니다.";
    public static final String NUMBER_INPUT_RANGE_ERROR_MESSAGE =
            "[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        tempNumbers.sort(Comparator.naturalOrder());
        List<Integer> sortedNumbers = List.copyOf(tempNumbers);

        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public Lotto(Lotto referenceLotto) {
        this.numbers = List.copyOf(referenceLotto.getNumbers());
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_INPUT_COUNT_ERROR_MESSAGE);
        }
        if (numbers.get(0) < MIN_NUMBER || numbers.get(NUMBER_COUNT - 1) > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_INPUT_RANGE_ERROR_MESSAGE);
        }
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

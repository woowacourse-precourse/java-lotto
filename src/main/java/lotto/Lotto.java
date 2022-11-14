package lotto;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = LottoDrawMachine.LOTTO_NUMBERS_SIZE;
    public static final int MIN_VALUE = LottoDrawMachine.MIN_VALUE;
    public static final int MAX_VALUE = LottoDrawMachine.MAX_VALUE;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isNotConstantSize(numbers);
        isNotRangeFromMinToMax(numbers);
        existsDuplicateNumbers(numbers);
    }

    private void isNotConstantSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR]: 로또의 사이즈는 6이여야 합니다.");
        }
    }

    private void isNotRangeFromMinToMax(List<Integer> numbers) {
        numbers.stream().forEach(this::isNotRangeFromMinToMax);
    }

    private void isNotRangeFromMinToMax(Integer number) {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("[ERROR]: 숫자의 범위는 1 ~ 45까지여야 합니다.");
        }
    }

    private void existsDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]: 중복되는 숫자가 존재합니다.");
        }
    }

    public String toString() {
        String output = "";
        for (int number : numbers) {
            output += String.valueOf(number);
            output += ", ";
        }
        output = output.substring(0, output.length() - 2); // ", ".length() == 2 마지막 ", " 제거
        return "[" + output + "]";
    }
}

package lotto.data;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_PARAMETER_FOR_NEW_INSTANCE = "로또 번호는 1부터 45 사이의 서로 다른 6개의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        int index;
        for (index = 0; index < this.numbers.size() - 1; ++index) {
            stringBuilder.append(this.numbers.get(index)).append(", ");
        }
        stringBuilder.append(this.numbers.get(index)).append("]");

        return stringBuilder.toString();
    }

    public static void validate(List<Integer> numbers) {
        if (!isNumbersSizeExactlySix(numbers) || !isEveryNumberDistinct(numbers) || !isEveryNumberInRange(numbers)) {
            throw new IllegalArgumentException(INVALID_PARAMETER_FOR_NEW_INSTANCE);
        }
    }

    public static boolean isNumbersSizeExactlySix(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public static boolean isEveryNumberDistinct(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    public static boolean isEveryNumberInRange(List<Integer> numbers) {
        List<Integer> filtered = numbers.stream().filter(num -> num >= 1 && num <= 45).collect(Collectors.toList());
        return filtered.size() == numbers.size();
    }
}

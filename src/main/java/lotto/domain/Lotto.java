package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (!isLength(numbers)) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해주세요.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!isInRange(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지 숫자를 입력해주세요.");
            }
            if (isDuplicate(numbers, numbers.get(i), i)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    private static boolean isLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private static boolean isInRange(Integer number) {
        Integer minNum = 1;
        Integer maxNum = 45;
        return number.compareTo(minNum) != -1
                && number.compareTo(maxNum) != 1;
    }

    private static boolean isDuplicate(List<Integer> numbers, Integer num, int index) {
        for (int j = 0; j < index; j++) {
            if (numbers.get(j).equals(num)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

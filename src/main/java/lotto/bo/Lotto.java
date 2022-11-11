package lotto.bo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            System.out.println("[ERROR] 로또 번호는 6개이어야합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                System.out.println("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야합니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

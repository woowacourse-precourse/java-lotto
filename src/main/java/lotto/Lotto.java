package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 입력된 변수 검증
    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        for(int n : numbers) {
            if(n < MINIMUM_NUMBER || MAXIMUM_NUMBER < n) {
                throw new IllegalArgumentException();
            }
        }
    }
    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> sixNumbers = new HashSet<Integer>();
        sixNumbers.addAll(numbers);
        if (sixNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // 랜덤 로또 번호 생성
    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void sortAscNumbers() {
        Collections.sort(numbers);
    }
}

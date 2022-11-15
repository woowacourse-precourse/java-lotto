package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        List<Integer> numbers = new ArrayList<Integer>(lottoNumbers);  // 수정 가능한 리스트로 변환
        validate(numbers);
        sortAscNumbers(numbers);
        this.numbers = numbers;
    }

    // 입력된 변수 검증
    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < MINIMUM_NUMBER || MAXIMUM_NUMBER < n) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> sixNumbers = new HashSet<Integer>();
        sixNumbers.addAll(numbers);
        if (sixNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야합니다.");
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

    public void sortAscNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}

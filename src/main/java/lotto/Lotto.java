package lotto;

import javax.naming.PartialResultException;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    final static String INFORMATION_ERROR_INPUT_SIZE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    final static String INFORMATION_ERROR_DUPLICATED_NUMBER = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void sortNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }

    public boolean contain(Integer number) {
        return numbers.contains(number);
    }

    public int compare(Lotto lotto) {
        return (int)numbers.stream()
                .filter(lotto::contain)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INFORMATION_ERROR_INPUT_SIZE);
        }

        Set<Integer> checkDuplicatedNumbers = new HashSet<>(numbers);
        if ( checkDuplicatedNumbers.size() != numbers.size() ) {
            throw new IllegalArgumentException(INFORMATION_ERROR_DUPLICATED_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
}

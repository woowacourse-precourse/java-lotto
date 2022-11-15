package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 한장의 로또 티켓 정보를 관리하는 클래스
 */
public class Lotto {


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!validateConsistOfSixNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        if (!validateEachNumberInRange(numbers)) {
            throw new IllegalArgumentException("로또 번호의 각 숫자는 1~45 사이의 값을 가져야 합니다.");
        }

        if (!validateEachNumberIsDistinct(numbers)) {
            throw new IllegalArgumentException("로또 번호의 숫자들은 중복되어서는 안됩니다.");
        }
    }

    private boolean validateEachNumberInRange(List<Integer> numbers) {
        return numbers.stream().allMatch((number) -> 1 <= number && number <= 45);
    }

    private boolean validateConsistOfSixNumber(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean validateEachNumberIsDistinct(List<Integer> numbers) {
        return numbers.stream().distinct().count() == 6;
    }

    // TODO: 추가 기능 구현

    public int getCountOfMatchNumber(Lotto otherLotto) {
        Set<Integer> copiedNumber = new HashSet<>(numbers);
        copiedNumber.retainAll(otherLotto.numbers);

        return copiedNumber.size();
    }


    public boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}

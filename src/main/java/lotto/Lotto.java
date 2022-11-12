package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
        sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 갯수가 6개가 아닙니다.");
        }
    }
    private void duplicateValidate(List<Integer> numbers) {
        // 2-1. 로또 번호는 중복되지 않게 한다.
        if(new HashSet<>(numbers).size() != numbers.size())
            throw new IllegalArgumentException("로또 번호가 중복되었습니다.");
    }

    private void sort(List<Integer> numbers) {
        // 2-2. 로또 번호를 오름차순으로 정렬시킨다.
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

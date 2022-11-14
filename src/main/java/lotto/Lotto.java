package lotto;

import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancy(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하셔야합니다.");
        }
    }
    private void redundancy(List<Integer> numbers){
        Set<Integer> numbersFilter = Sets.newHashSet(numbers);
        if(numbersFilter.size() != 6){
            throw new IllegalArgumentException("[ERROR] 입력하신 값에 중복이 존재합니다.");
        }
    }

}

package lotto.domain;

import lotto.config.InputConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;        // 접근 제어자 수정 금지

    // 필드 추가 금지
    public Lotto(List<Integer> numbers) {       // 디폴트 생성자 사용 금지
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        InputConfig.checkPrizeLotto(lotto);
    }

    @Override
    public String toString() {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        return sorted.toString();
    }

    public boolean contains(int prizeBonusNumber) {
        return numbers.contains(prizeBonusNumber);
    }

    public Set<Integer> toSet() {
        return new HashSet<>(numbers);
    }

}

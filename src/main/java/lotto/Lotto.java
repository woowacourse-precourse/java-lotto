package lotto;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private void validateDuplicatedNumber(List<Integer> numbers){
        if (new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInRange(List<Integer> numbers){
        numbers.stream().filter(n -> !(1 <= n && n <= 45)).findAny()
                .ifPresent(m -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                });
    }
}

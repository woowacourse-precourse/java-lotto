package lotto;
import java.util.*;

public class Lotto {
    //final은 값이 변하지 않는다. 객체를 생성하고 Lotto를 호출했을 때 넣은 numbers 그대로 유지하게 된다.
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

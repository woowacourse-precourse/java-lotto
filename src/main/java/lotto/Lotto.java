package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 생성을 위해서는 6개의 숫자가 필요합니다.");
        }
        // 범위 벗어날 때
        // 중복된 숫자 있을 때.
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        // TODO: 투스트링 쓰지말고 출력 뷰에 정의할 것
        String start = "[";
        String end = "]";
        String delimiter = ", ";

        String lottoStr = this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
        return start + lottoStr + end;
    }
}

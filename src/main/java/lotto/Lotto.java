package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {      // 리스트 사이즈가 6이 아니면 예외 처리한다.
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개로 구성되어야 합니다.");
        }

        // 중복인 경우, 예외 처리한다.
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if (map.get(n) > 1) {
                throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");

            }
        }

    }

}

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

    /* 예외처리
    사이즈 6인지 확인
    1 ~ 45 확인
    중복 확인
     */


    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 구성되어야 합니다.");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if (map.get(n) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");

            }

            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

            }

        }

    }

}

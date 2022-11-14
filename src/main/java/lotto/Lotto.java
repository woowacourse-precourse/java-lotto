package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 6개여야 합니다.");
            }
            for (int i = 0; i < 6; i++) {
                if (numbers.get(i) > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또번호는 46보다 작아야합니다");
                } else if (numbers.get(i) < 1) {
                    throw new IllegalArgumentException("[ERROR] 로또번호는 0보다 커야합니다");
                } else if (numbers.size() != numbers.stream().distinct().count()) {
                    throw new IllegalArgumentException("[ERROR] 로또번에 중복된 숫자가 존재합니다");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또번호 입력이 잘못됐습니다.");
        }
    }

    // TODO: 추가 기능 구현
}

package lotto.domain;

import lotto.setting.Setting;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Setting.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개 숫자를 입력해야 합니다.");
        }
    }
}

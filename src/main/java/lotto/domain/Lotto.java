package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static int[] rank = {0, 0, 0, 0, 0};

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int compareLotto(List<Integer> playerLotto, int bonusNumber) {
        int matchCount = 0;
        boolean matchBonus = numbers.contains(bonusNumber);
        for (Integer lotto : playerLotto) {
            if (numbers.contains(lotto)) {
                matchCount++;
            }
        }
        if (matchCount == 5 && !matchBonus) {
            return 4;
        }
        return 6 - matchCount;
    }
}

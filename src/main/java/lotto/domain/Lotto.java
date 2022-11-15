package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 길이가 6이 아닙니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 중복되고 있습니다.");
        }
        if (numbers.stream().mapToInt(v -> v).max().getAsInt() > 45 && numbers.stream().mapToInt(v -> v).min().getAsInt() < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 1~45 사이가 아닙니다.");
        }
    }
}

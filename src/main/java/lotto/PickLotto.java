package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickLotto {
    private final List<Integer> numbers;

    public PickLotto(String input) {
        String[] split = input.split(",");
        numberValidate(split);
        this.numbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void numberValidate(String[] split) {
        // 3-1. 쉼표를 기준으로 나누었을때 숫자가 아니면 예외처리를 한다.
        for (String s : split) {
            if (!s.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException();
        }
    }
}

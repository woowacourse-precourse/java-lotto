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
        countValidate(split);
        rangeValidate(split);
        duplicateValidate(split);
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

    private void countValidate(String[] split) {
        // 3-2. 쉼표를 기준으로 나누었을때 숫자가 6개가 아니면 예외처리를 한다.
        if (split.length != 6) throw new IllegalArgumentException();
    }

    private void rangeValidate(String[] split) {
        // 3-3. 쉼표를 기준으로 나눈 숫자가 숫자 범위 1~45 사이에 없으면 예외처리를 한다.
        for (String s : split) {
            if (!(1<= Integer.parseInt(s) && Integer.parseInt(s) <= 45)) throw new IllegalArgumentException();
        }
    }

    private void duplicateValidate(String[] split) {
        // 3-4. 쉼표를 기준으로 나눈 숫자가 중복되면 예외처리를 한다.
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            if (numbers.contains(Integer.parseInt(s))) throw new IllegalArgumentException();
            else numbers.add(Integer.parseInt(s));
        }
    }
}

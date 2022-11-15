package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;



public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        this.numbers = numbers;

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("가능 숫자 범위를 벗어났습니다!");
            }
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다!");
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}

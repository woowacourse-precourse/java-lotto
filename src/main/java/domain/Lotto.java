package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호 길이가 잘못되었습니다");
            System.exit(0);
        }

    }

    // TODO: 추가 기능 구현
    private void validateOverlap(List<Integer> numbers) {
        HashSet<Integer> numbersOverlap = new HashSet<>(numbers);
        try {
            if (numbers.size() != numbersOverlap.size())
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호에 중복된 값이 있습니다");
            System.exit(0);
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}

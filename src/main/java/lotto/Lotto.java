package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    
    // TODO: 추가 기능 구현
    // 로또 넘버가 중복될 때 예외
    public void validateOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 로또 번호가 중복되었습니다.");
            throw new IllegalArgumentException();
        }
    }
}

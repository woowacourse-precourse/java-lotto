package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        List<Integer> sortOfNumbers = new ArrayList<>();
        for (Integer number:numbers){
            Input.validateNotDuplicated(sortOfNumbers, String.valueOf(number));
            sortOfNumbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}

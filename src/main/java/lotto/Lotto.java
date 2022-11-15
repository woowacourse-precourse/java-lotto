package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자가 6개가 아닙니다.");
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }


        for (int i = 0; i < numbers.size(); i++) {
            if (!(numbers.get(0) >= 1 && numbers.get(0) <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자가 아닙니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}

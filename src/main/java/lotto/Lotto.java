package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sameNumValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리 수 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void sameNumValidate(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            System.out.println("[ERROR] 로또 번호는 같은 숫자는 숫자는 포함되면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}

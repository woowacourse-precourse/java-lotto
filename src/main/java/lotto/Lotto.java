package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            System.out.println("[Error]당첨번호는 6자리이여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbersSet.size()){
            System.out.println("[Error]중복되지 않은 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if(Collections.min(numbers) < 1 || Collections.max(numbers) >45 ) {
            System.out.println("[Error]1~45 범위의 값을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현
}

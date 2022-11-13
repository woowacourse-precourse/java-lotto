package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.forEach(this::rangeCheck);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개로 입력해주세요");
        }
    }

    private void rangeCheck(int number){
        if(number<1||number>45){
            throw new IllegalArgumentException("[ERROR] 로또번호는 1부터 45사이입니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers){
        Set<Integer> testNumbers = new HashSet<>(numbers);
        if(numbers.size()!= testNumbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
}

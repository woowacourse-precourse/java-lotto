package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }
    // 숫자 개수 확인
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 발행된 로또의 숫자가 6개가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    // 해당 로또의 번호 가져오기
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void sortNumbers(List<Integer> number){
        Collections.sort(number);
    }

}

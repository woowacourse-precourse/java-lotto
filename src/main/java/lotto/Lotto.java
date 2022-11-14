package lotto;

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
            throw new IllegalArgumentException("6개 숫자를 입력해주세요");
        }
        List<Integer> compareNumbers = new ArrayList<>();
        for(int number : numbers){
            if(compareNumbers.contains(number)){
                throw new IllegalArgumentException("6개 숫자는 서로 달라야 합니다.");
            }
            compareNumbers.add(number);
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}

package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNum(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateNum(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않습니다.");
        }
    }

//    public List<Integer> sortAsc(List<Integer> numbers){
//        numbers.sort(Comparator.naturalOrder());
//        return numbers;
//    }
    public String toString(){
        return String.valueOf(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

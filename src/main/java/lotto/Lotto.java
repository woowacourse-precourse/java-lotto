package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("입력된 번호의 개수가 6개가 아닙니다.");
        }
        validateOverlap(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers){
        for(int number:numbers){
            validateNumber(number);
        }
    }

    void validateNumber(int number){
        if (number<1||number>45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers){
        Set<Integer> overlap=new HashSet<>(numbers);
        if(overlap.size()!=6){
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    public void printLotto(){
        System.out.println(numbers.toString());
    }
    // TODO: 추가 기능 구현
    // lotto 판단
}

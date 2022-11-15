package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < 6; i++){
            if(numbers.indexOf(i) < 1 || numbers.indexOf(i) > 45){
                throw new IllegalArgumentException();
            }
        }
    }
    // TODO: 추가 기능 구현

    public void printNumber(){
        System.out.println(numbers);
    }
}

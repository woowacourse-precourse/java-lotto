package lotto;

import java.util.List;

public class Lotto { //public class Lotto
    private final List<Integer> numbers; // private final List>,Integer
/*constructor
* public Lotto(List<Integer>numbers){
* validate(numbers);
* this.numbers
* }
*
* */
    public Lotto(List<Integer> numbers) {   // public Lotto (List<Integer>numbers)
        validate(numbers);
        this.numbers = numbers;
    }
/*
private void validate(List<Integer>numbers){
    if (numbers.size()!=6){
        throw new IllegalArgumentException();
    }
}
*
* */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}

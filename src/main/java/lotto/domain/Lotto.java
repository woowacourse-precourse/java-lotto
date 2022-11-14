package lotto.domain;



import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numlist) {
        validate(numlist);
        this.numbers = numlist;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Boolean contains(int value){
        return numbers.contains(value);
    }
}
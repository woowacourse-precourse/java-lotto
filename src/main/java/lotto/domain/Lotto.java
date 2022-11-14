package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        validate(tmpNumbers);
        sortNumber(tmpNumbers);
        this.numbers = tmpNumbers;
    }

    private void sortNumber(List<Integer> list){
        Collections.sort(list);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
}

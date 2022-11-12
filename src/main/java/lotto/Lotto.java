package lotto;

import jdk.jshell.execution.Util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (!(Collections.max(numbers) <= Utility.maxLottoNumber && Collections.min(numbers) >= Utility.minLottoNumber)){
            throw new IllegalArgumentException();
        }
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size()!= numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private List <Integer> sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}

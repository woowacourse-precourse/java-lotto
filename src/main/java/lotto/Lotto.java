package lotto;

import jdk.jshell.execution.Util;

import java.util.*;

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
        List <Integer> _numbers = new ArrayList<>(numbers);
        Collections.sort(_numbers);
        return _numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

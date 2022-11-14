package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> lottoNumbers = new LinkedList<>(numbers);
        Collections.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkEachNumber(numbers);
        checkDuplication(numbers);
    }

    private void checkSize(List<Integer> numbers){
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkEachNumber(List<Integer> numbers){
        for(Integer num: numbers){
            checkRange(num);
        }
    }

    private void checkRange(int number){
        if(number > MAX || number < MIN){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplication(List<Integer> input){
        HashSet<Integer> checker = new HashSet<>(input);
        if(checker.size() != SIZE){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateCnt(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 ) {
            throw new IllegalArgumentException();
        }
    }
    private void validateCnt(List<Integer> numbers){
        int numCnt = new HashSet<>(numbers).size();
        if (numCnt != 6 ) {
            throw new IllegalArgumentException();
        }

    }
}

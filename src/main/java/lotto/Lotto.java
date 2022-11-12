package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        Set<Integer> temp = new HashSet<>();
        for (int elem : numbers) {
            if (!temp.add(elem)){
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public boolean containsTheNumber(int number){
        return numbers.contains(number);
    }

}

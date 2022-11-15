package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        random(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void random(List<Integer> numbers) {
        Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> duplicate(List<Integer> numbers){
        HashSet<Integer> checknumbers = new HashSet<Integer>(numbers);
        return new ArrayList<Integer>(checknumbers);
    }
}

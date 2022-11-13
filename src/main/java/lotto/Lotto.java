package lotto;

import java.util.List;
import java.util.Objects;

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
    }

    void printLotto(){
        System.out.println(numbers);
    }

    int matchWinning(List<Integer> winning) {
        int result = 0;
        for (int winNum: winning) {
            if (numbers.contains(winNum)) {
                result++;
            }
        }
        return result;
    }

    boolean matchBonus(int bonus) {
        return numbers.contains(bonus);
    }
}

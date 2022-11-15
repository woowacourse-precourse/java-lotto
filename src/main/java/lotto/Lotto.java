package lotto;

import java.util.Collections;
import java.util.List;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validate.checkValidWinningNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }
}

package lotto;

import java.util.List;

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

    public Prize getPrize(List<Integer> winningNumbers, int bonus){
        int counter = 0;
        for(Integer num : numbers){
            if(winningNumbers.contains(num))
                counter++;
        }
        boolean bonusRight = numbers.contains(bonus);
        return Prize.getPrize(counter, bonusRight);
    }

}

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

    // TODO: 추가 기능 구현
    public int howManyWinningNumbers(List<Integer> winningNumber){
        int winningNumberCount = 0;

        for(int i = 0 ; i < winningNumber.size() ; i++)
            if(numbers.contains(winningNumber.get(i)))
                winningNumberCount++;

        return winningNumberCount;
    }
}

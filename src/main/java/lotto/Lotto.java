package lotto;

import java.util.Collections;
import java.util.List;
import lotto.Application.Places;
import lotto.Application.NumberType;
import static lotto.Application.noOfLottoWinAt;
import static lotto.Application.numberTypeCheck;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
        print(this.numbers);
        updateResult(this.numbers);
    }

    private void print(List<Integer> numbers) { System.out.println(numbers); }

    private Places compareResult(int countWinningNumbers, boolean isBonusNumber) {
        if(countWinningNumbers < 3) return Places.NONE;
        if(countWinningNumbers == 6) return Places.FIRST;
        if(countWinningNumbers == 4) return Places.FOURTH;
        if(countWinningNumbers == 3) return Places.FIFTH;
        if(isBonusNumber) return Places.SECOND;
        return Places.THIRD;
    }

    private Places countNumberTypes(List<Integer> numbers) {
        int countWinningNumbers = 0;
        boolean isBonusNumber = false;
        for (int number : numbers) {
            if(numberTypeCheck[number] == NumberType.WINNING)
                countWinningNumbers++;
            if(numberTypeCheck[number] == NumberType.BONUS)
                isBonusNumber = true;
        }
        return compareResult(countWinningNumbers, isBonusNumber);
    }

    private void updateResult(List<Integer> numbers) {
        Places result = countNumberTypes(numbers);
        int count = noOfLottoWinAt.get(result);
        noOfLottoWinAt.put(result, count + 1);
    }
}
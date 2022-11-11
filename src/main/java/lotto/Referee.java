package lotto;

import java.util.List;

import static lotto.Rank.*;

public class Referee {

    public int correctNumberCount(Lotto input, List<Integer> numbers) {
        int count = 0;

        for(int number : numbers) {
            if(input.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void plusCorrectNumberCount(int correctNumberCount, List<Integer> numbers, int bonus) {
        if(correctNumberCount == 3) {
            THREE.plusCount();
        }
        if(correctNumberCount == 4) {
            FOUR.plusCount();
        }
        if(correctNumberCount == 5) {
            if(numbers.contains(bonus)) {
                FIVE_BONUS.plusCount();
                return;
            }
            FIVE.plusCount();
        }
        if(correctNumberCount == 6) {
            SIX.plusCount();
        }
    }

}

package lotto;

import java.util.List;

import static lotto.Rank.*;

public class Referee {

    public int correctNumberCount(Lotto lotto, List<Integer> myLotto) {
        int count = 0;

        for(int number : myLotto) {
            if(lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void plusCorrectNumberCount(int correctNumberCount, List<Integer> myLotto, int bonus) {
        if(correctNumberCount == 3) {
            THREE.plusCount();
        }
        if(correctNumberCount == 4) {
            FOUR.plusCount();
        }
        if(correctNumberCount == 5) {
            if(myLotto.contains(bonus)) {
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

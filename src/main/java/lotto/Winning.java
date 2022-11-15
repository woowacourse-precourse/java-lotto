package lotto;

import java.util.List;

public class Winning {



    private int countMatchNumber(Lotto lotto, List<Integer> WinningNumbers){
        List<Integer> numbers = lotto.getNumbers();
        int matchNumber = 0;
        for (Integer number : numbers){
            if (WinningNumbers.contains(number)){
                matchNumber += 1;
            }
        }
        return matchNumber;
    }


    private boolean countBonusNumber(Lotto lotto, int bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        return (numbers.contains(bonusNumber));
    }
}

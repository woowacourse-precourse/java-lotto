package lotto.calculation;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private final List<Integer> winningNumbers;

    public Winning(List<String> winningNumbers) {
        List<Integer> parsingWinningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            parsingWinningNumbers.add(Integer.parseInt(winningNumber));
        }
        this.winningNumbers = parsingWinningNumbers;
    }
}

package lotto.calculation;

import lotto.exception.IllegalArgument;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private final List<Integer> winningNumbers;

    public Winning(List<String> winningNumbers) {
        List<Integer> parsingWinningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            if (!IllegalArgument.isNumber(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
            }
            parsingWinningNumbers.add(Integer.parseInt(winningNumber));
        }
        this.winningNumbers = parsingWinningNumbers;
    }
}

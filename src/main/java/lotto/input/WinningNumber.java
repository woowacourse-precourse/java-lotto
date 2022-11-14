package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.exception.WinningNumbersException;

public class WinningNumber {
    public Lotto getCorrect() {
        WinningNumbersException exception = new WinningNumbersException();
        List<Integer> answerNumbers = new ArrayList<>();
        String input = Console.readLine();

        exception.winningNumbersVerification(input);
        answerNumbers = numberConversion(answerNumbers, input);
        return new Lotto(answerNumbers);
    }

    public List<Integer> numberConversion(List<Integer> answerNumbers, String input) {
        for (String word : input.split(",")) {
            int number = Integer.parseInt(word);
            answerNumbers.add(number);
        }
        return answerNumbers;
    }
}
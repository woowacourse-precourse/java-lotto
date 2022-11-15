package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public Lotto getCorrect() {
        List<Integer> answerNumbers = new ArrayList<>();
        String input = Console.readLine();

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
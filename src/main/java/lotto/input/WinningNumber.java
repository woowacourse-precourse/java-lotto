package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public Lotto getAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();
        String input = Console.readLine();

        for (String number : input.split(",")) {
            int integer = Integer.parseInt(number);
            answerNumbers.add(integer);
        }
        return new Lotto(answerNumbers);
    }
}
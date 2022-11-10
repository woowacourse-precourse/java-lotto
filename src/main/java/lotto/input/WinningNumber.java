package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public void answer() {
        List<Integer> answerNumbers = new ArrayList<>();
        String strInput = Console.readLine();

        for (String number : strInput.split(",")) {
            int integer = Integer.parseInt(number);
            answerNumbers.add(integer);
        }
        new Lotto(answerNumbers);
    }
}

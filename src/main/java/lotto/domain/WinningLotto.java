package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Message.WINNING_NUMBER_INPUT;

import java.util.stream.Stream;
import lotto.view.ErrorMessage;

public class WinningLotto {

    public void winningNumberInput() {
        System.out.println(WINNING_NUMBER_INPUT.getMessage());
        String winningNumber = readLine();
    }
}

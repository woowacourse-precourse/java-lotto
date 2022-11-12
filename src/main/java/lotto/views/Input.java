package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;
import lotto.utils.GameMessage;
import lotto.utils.InputValidation;

public class Input {

    private final InputValidation inputValidation;

    public Input() {
        inputValidation = new InputValidation();
    }

    public int getUserMoney() {
        System.out.println(GameMessage.BUY_FOR_LOTTO);

        String question = Console.readLine();
        inputValidation.checkNumber(question, Constant.REGEX_INPUT);
        inputValidation.checkThousandMoney(question);

        return Integer.parseInt(question);
    }

    public void getWinningNumber() {
        System.out.print('\n' + GameMessage.INPUT_WINNING_NUMBER + '\n');

        String answer = Console.readLine();
        inputValidation.checkNumber(answer, Constant.REGEX_WINNING_NUMBER_INPUT);
    }

}

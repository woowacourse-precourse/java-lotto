package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoDrawing;

import static constants.Message.*;

public class UserInput {

    public LottoDrawing getWinningNumber() {
        System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
        String inputWinningNumber = Console.readLine();

        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        String inputBonusNumber = Console.readLine();

        return new LottoDrawing(inputWinningNumber, inputBonusNumber);
    }

}

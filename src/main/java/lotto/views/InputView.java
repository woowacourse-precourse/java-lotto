package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.message.InputMessage;

public class InputView {

    public String inputPrice() {
        System.out.println(InputMessage.INPUT_PRICE);
        return Console.readLine();
    }

    public void printInputPriceAgain() {
        System.out.println(InputMessage.INVALID_INPUT_PRICE);
    }

    public List<String> inputWinningNumber() {
        String lottoNumber = inputLottoNumber();
        String bonusNumber = inputBonusNumber();
        return List.of(lottoNumber, bonusNumber);
    }

    private static String inputLottoNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}

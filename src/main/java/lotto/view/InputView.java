package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.utils.LottoConvertor;
import lotto.utils.UserInputValidator;

import static lotto.utils.Constants.*;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        UserInputValidator.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public static Lotto inputWinningNumber() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        String userInput = Console.readLine();
        return LottoConvertor.mapToLotto(userInput);
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
        String userInput = Console.readLine();
        return LottoConvertor.mapToLottoNumber(userInput);
    }
}

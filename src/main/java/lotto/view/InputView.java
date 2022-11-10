package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.LottoConvertor;
import lotto.utils.UserInputValidator;

public class InputView {

    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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

    public static int inputBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
        String userInput = Console.readLine();
        return LottoConvertor.mapToInt(userInput);
    }
}

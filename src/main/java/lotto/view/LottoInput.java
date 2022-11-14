package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinningNumber;
import lotto.valid.InputLottoValidator;

public class LottoInput {
    private static final String INPUT_PAY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static InputLottoValidator inputLottoValidator;
    private static String winningNumber;

    public static String getWinningNumber() {
        return winningNumber;
    }

    public static String inputPayMoney() {
        inputLottoValidator = new InputLottoValidator();

        System.out.println(INPUT_PAY_MONEY);

        String payMoney = Console.readLine();
        inputLottoValidator.validateMoney(payMoney);

        System.out.println("");
        return payMoney;
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        String winningNumber = Console.readLine();
        inputLottoValidator.validateWinningNumbers(winningNumber);

        System.out.println("");
        LottoInput.winningNumber = winningNumber;
        return winningNumber;
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        String bonusNumber = Console.readLine();
        inputLottoValidator.validateBonusNumber(bonusNumber, getWinningNumber());

        System.out.println("");
        return bonusNumber;
    }
}

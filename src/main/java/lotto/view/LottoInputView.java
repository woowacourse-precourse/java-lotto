package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringSeparator;
import lotto.validator.BuyAmountValidator;
import lotto.validator.WinningNumberValidator;

import java.util.List;

public class LottoInputView {
    private static String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    StringSeparator stringSeparator = new StringSeparator();
    WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    BuyAmountValidator buyAmountValidator = new BuyAmountValidator();

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        String inputBuyAmount = Console.readLine();
        buyAmountValidator.validateInputNumber(inputBuyAmount);
        return Integer.parseInt(inputBuyAmount);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = stringSeparator.separateStringToList(inputWinningNumbers);
        winningNumberValidator.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        winningNumberValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}

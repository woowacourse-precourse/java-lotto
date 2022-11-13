package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputBuyingAmount() {
        System.out.println(REQUEST_MONEY);
        String buyingAmount = Console.readLine();
        InputViewValidation.validateIsInteger(buyingAmount);
        InputViewValidation.validateIs1000(buyingAmount);

        return Integer.parseInt(buyingAmount);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();
        InputViewValidation.validateWinningNumbersFormat(winningNumbers);
        InputViewValidation.validateWinningNumbersSize(winningNumbers);
        InputViewValidation.validateWinningNumbersInteger(winningNumbers);
        InputViewValidation.validateWinningNumbersRange(winningNumbers);
        InputViewValidation.validateWinningNumbersUnique(winningNumbers);

        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        InputViewValidation.validateIsInteger(bonusNumber);
        InputViewValidation.validateBonusNumberRange(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

}

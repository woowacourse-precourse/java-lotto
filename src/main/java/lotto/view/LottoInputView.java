package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.InputValidator;

public class LottoInputView {

    private String input() {
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = input();
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumber() {
        String winningNumber = input();
        InputValidator.validateWinningNumber(winningNumber);
        return toIntegerNumberList(winningNumber);
    }

    private List<Integer> toIntegerNumberList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String bonusNumber = input();
        InputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}

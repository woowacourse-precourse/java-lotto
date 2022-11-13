package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.InputValidator;

public class LottoInput {
    private final InputValidator inputValidator = new InputValidator();

    public String inputLottoGame() {
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = inputLottoGame();
        inputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumber() {
        String winningNumber = inputLottoGame();
        inputValidator.validateWinningNumber(winningNumber);
        return toIntegerNumberList(winningNumber);
    }

    public List<Integer> toIntegerNumberList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}

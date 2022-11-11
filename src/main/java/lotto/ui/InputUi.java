package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputUi {

    private static final String NUMBER_INPUT_DIVIDER = ",";

    public static int readPurchaseAmount() throws IllegalArgumentException {
        String amountInput = Console.readLine();
        InputValidator.validateIsNumber(amountInput);

        int purchaseAmount = Integer.valueOf(amountInput);
        InputValidator.validateLottoPurchaseNumber(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> readWinningLottoNumbers() throws IllegalArgumentException {
        String winningNumbersInput = Console.readLine();
        InputValidator.validateWinningNumbersInput(winningNumbersInput);

        List<Integer> winningNumbers = splitNumbersStringToList(winningNumbersInput);
        return Collections.unmodifiableList(winningNumbers);
    }

    private static List<Integer> splitNumbersStringToList(String numberInput) {
        String[] dividedNumbersInput = numberInput.split(NUMBER_INPUT_DIVIDER);

        List<Integer> numbers = new ArrayList<>();
        for (String number : dividedNumbersInput) {
            numbers.add(Integer.valueOf(number));
        }

        return Collections.unmodifiableList(numbers);
    }

}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.resources.InputMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String EMPTY_ROW = "";
    private final String DELIMITER = ",";

    public int enterPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = Console.readLine();
        InputException.validatePurchaseAmount(purchaseAmount);
        System.out.println(EMPTY_ROW);
        return Integer.valueOf(purchaseAmount);
    }

    public List<Integer> enterWinningNumber() {
        System.out.println(InputMessage.WINNING_NUMBER.getMessage());
        String[] numbers = Console.readLine().split(DELIMITER);
        List<Integer> winningNumber = Arrays.stream(numbers)
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
        InputException.validateWinningNumber(winningNumber);
        Collections.sort(winningNumber);
        System.out.println(EMPTY_ROW);
        return winningNumber;
    }

    public int enterBonusNumber(List<Integer> winningNumber) {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        int bonusNumber = Integer.valueOf(Console.readLine());
        InputException.validateBonusNumber(bonusNumber, winningNumber);
        System.out.println(EMPTY_ROW);
        return bonusNumber;
    }

}

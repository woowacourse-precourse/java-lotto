package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.resources.InputMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String NEWLINE = "";
    InputMessage inputMessage;

    public int enterPurchaseAmount() {
        System.out.println(inputMessage.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = Console.readLine();
        InputException.validatePurchaseAmount(purchaseAmount);
        System.out.println(NEWLINE);
        return Integer.valueOf(purchaseAmount);
    }

    public List<Integer> enterWinningNumber() {
        System.out.println(inputMessage.WINNING_NUMBER.getMessage());
        String[] numbers = Console.readLine().split(",");
        List<Integer> winningNumber = Arrays.stream(numbers)
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
        InputException.validateWinningNumber(winningNumber);
        Collections.sort(winningNumber);
        System.out.println(NEWLINE);
        return winningNumber;
    }

    public int enterBonusNumber(List<Integer> winningNumber) {
        System.out.println(inputMessage.BONUS_NUMBER.getMessage());
        int bonusNumber = Integer.valueOf(Console.readLine());
        InputException.validateBonusNumber(bonusNumber, winningNumber);
        System.out.println(NEWLINE);
        return bonusNumber;
    }

}

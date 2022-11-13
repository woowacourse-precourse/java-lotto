package lotto.util;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {

    final static int SIZE_OF_LOTTO_NUMBER = 6;

    public static int parsePurchaseAmountInput(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);

        if (!ValidationUtil.validatePositiveNum(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        if (!ValidationUtil.validateRemainder(purchaseAmount)) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount;
    }

    public static List<Integer> parseWinningNumbersInput(String winningNumsInput) {
        if (!ValidationUtil.isLengthIncludingComma(winningNumsInput)) {
            throw new IllegalArgumentException();
        }

        if (!ValidationUtil.isComma(winningNumsInput)) {
            throw new IllegalArgumentException();
        }
        return parseSplittedInput(winningNumsInput);
    }

    private static List<Integer> parseSplittedInput(String winningNumsInput) {
        List<Integer> winningNumList = new ArrayList<>();
        List<String> splittedWinningNumsList = InputView.revertInputToList(winningNumsInput);

        for (String winningNumStr : splittedWinningNumsList) {
            if (!ValidationUtil.isDigit(winningNumStr)) {
                throw new IllegalArgumentException();
            }

            Integer winningNum = Integer.parseInt(winningNumStr);

            if (!ValidationUtil.isInRange(winningNum)) {
                throw new IllegalArgumentException();
            }

            if (ValidationUtil.isDuplicate(winningNumList, winningNum)) {
                throw new IllegalArgumentException();
            }

            winningNumList.add(winningNum);
        }
        return winningNumList;
    }

}

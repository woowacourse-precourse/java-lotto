package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_SIZE_ERROR;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_TYPE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_TYPE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_SIZE_ERROR;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_TYPE_ERROR;
import static lotto.constant.InputPattern.BONUS_NUMBER_PATTERN;
import static lotto.constant.InputPattern.PURCHASE_AMOUNT_PATTERN;
import static lotto.constant.InputPattern.WINNING_NUMBER_PATTERN;
import static lotto.constant.OutputMessage.PLEASE_WRITE_BONUS_NUMBER;
import static lotto.constant.OutputMessage.PLEASE_WRITE_PURCHASE_AMOUNT;
import static lotto.constant.OutputMessage.PLEASE_WRITE_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class CheckInput {

    public int readPurchaseAmount() {
        System.out.println(PLEASE_WRITE_PURCHASE_AMOUNT);

        String input = Console.readLine();

        return checkPurchaseAmountValid(input);
    }

    public int checkPurchaseAmountValid(String input) {
        checkPurchaseAmountPattern(input);

        int purchaseAmount = Integer.parseInt(input);

        checkPurchaseAmountRange(purchaseAmount);
        checkPurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public void checkPurchaseAmountPattern(String input) {
        Pattern pattern = Pattern.compile(PURCHASE_AMOUNT_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TYPE_ERROR);
        }
    }

    public void checkPurchaseAmountRange(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR);
        }
    }

    public void checkPurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR);
        }
    }

    public List<Integer> readWinningNumber() {
        System.out.println(PLEASE_WRITE_WINNING_NUMBERS);
        String input = Console.readLine();

        return checkWinningNumberValid(input);
    }

    public static List<Integer> checkWinningNumberValid(String input) {
        List<Integer> result = new ArrayList<>();

        checkWinningNumberPattern(input);

        String[] winningNumbers = input.split(",");
        checkWinningNumberSize(winningNumbers);

        for (int i = 0; i < winningNumbers.length; i++) {
            int winningNumber = Integer.parseInt(winningNumbers[i]);
            checkWinningNumberRange(winningNumber);
            result.add(winningNumber);
        }

        return result;
    }

    public static void checkWinningNumberPattern(String input) {
        Pattern pattern = Pattern.compile(WINNING_NUMBER_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(WINNING_NUMBER_TYPE_ERROR);
        }
    }

    public static void checkWinningNumberSize(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }
    }

    public static void checkWinningNumberRange(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR);
        }
    }

    private static void checkBonusNumberPattern(String input) {
        Pattern pattern = Pattern.compile(BONUS_NUMBER_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(BONUS_NUMBER_TYPE_ERROR);
        }
    }

    private static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_SIZE_ERROR);
        }
    }

}

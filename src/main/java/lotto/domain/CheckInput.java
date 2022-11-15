package lotto.domain;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_TYPE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static lotto.constant.InputPattern.PURCHASE_AMOUNT_PATTERN;
import static lotto.constant.InputPattern.WINNING_NUMBER_PATTERN;
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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 콤마(,)로 이루어져야 합니다.");
        }
    }

    public static void checkWinningNumberSize(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    public static void checkWinningNumberRange(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 사이의 양수입니다.");
        }
    }

}

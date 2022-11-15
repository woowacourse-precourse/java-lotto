package lotto;


import camp.nextstep.edu.missionutils.Console;

import static lotto.GuideMessage.*;
import static lotto.ErrorMessage.*;

public class Application {
    private static final int INVALID_PURCHASE_MONEY = -1;
    private static final int LOTTO_TICKET_MONEY = 1000;
    private static final int NEGATIVE_RANGE = 0;

    public static int getLottoPurchaseMoney() {
        System.out.println(INPUT_REQUEST_MESSAGE.getMessage());
        String userInput = Console.readLine();
        boolean valid = validateUserInput(userInput);
        if (valid) {
            int lottoPurchaseMoney = Integer.parseInt(userInput);
            return lottoPurchaseMoney;
        }
        return INVALID_PURCHASE_MONEY;
    }

    public static boolean validateUserInput(String userInput) throws IllegalArgumentException {
        boolean valid = checkLottoPurchaseMoneyValid(userInput);
        if (valid) {
            int lottoPurchaseMoney = Integer.parseInt(userInput);
            checkLottoPurchaseMoneyRange(lottoPurchaseMoney);
        }
        return valid;
    }

    public static boolean checkLottoPurchaseMoneyValid(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (Exception e) {
            IllegalArgumentException exception = new IllegalArgumentException();
            System.out.println(NOT_NUMBER_INPUT_MESSAGE.getMessage());
            return false;
        }
    }

    public static void checkLottoPurchaseMoneyRange(int lottoPurchaseMoney) throws IllegalArgumentException {
        if (lottoPurchaseMoney % LOTTO_TICKET_MONEY != 0 || lottoPurchaseMoney < NEGATIVE_RANGE) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY_MESSAGE.getMessage());
        }
    }

    public static void main(String[] args) {
        int lottoPurchaseMoney = getLottoPurchaseMoney();
    }
}
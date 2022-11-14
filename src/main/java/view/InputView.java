package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    private static final String BUYING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int showBuyingAmountMessage() {
        System.out.println(BUYING_AMOUNT_MESSAGE);
        String s = Console.readLine();
        int convertedAmount = getConvertedAmount(s);
        validateIsNaturalNumber(convertedAmount);
        return convertedAmount;
    }

    private static void validateIsNaturalNumber(int convertedAmount) {
        if (convertedAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 될 수 없습니다.");
        }
    }

    private static int getConvertedAmount(String s) {
        int convertedAmount;
        try {
            convertedAmount = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
            throw new NoSuchElementException("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
        }
        return convertedAmount;
    }

    public static String showEnterBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String stringBonusNumber = Console.readLine();
        validateIsDigit(stringBonusNumber);
        return stringBonusNumber;
    }

    private static void validateIsDigit(String stringBonusNumber) {
        try {
            Integer.parseInt(stringBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    public static String showEnterWinningNumberMessage() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }
}

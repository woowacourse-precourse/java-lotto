package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.type.ErrorType;
import lotto.type.TextType;

public class InputView {
    private static final String NUMBERS = "0123456789";

    public static String inputPurchaseAmount() {
        System.out.println(TextType.PURCHASE_INPUT_MESSAGE.getText());

        String input = Console.readLine();

        return input;
    }

    public static void isNumber(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (!NUMBERS.contains(input.substring(i,i+1))){
                throw new IllegalArgumentException(ErrorType.NOT_NUMBER_INPUT.getError());
            }
        }
    }

    public static void isValidUnit(int money) {
        int balance = money % 1000;
        if (balance > 0 || money < 0) throw new IllegalArgumentException(ErrorType.INVALID_UNIT.getError());
    }

    public static String inputWinNumber() {
        System.out.println(TextType.WIN_NUMBER_INPUT_MESSAGE.getText());

        String input = Console.readLine();

        return input;
    }

    public static void isValidFormat(String winNumberInput) {
        String[] numbers = winNumberInput.split(",");

        if (numbers.length != 6)
            throw new IllegalArgumentException(ErrorType.OVER_SIZE_WIN_NUMBER.getError());

        for (String number : numbers) {
            isNumber(number);

            if(Integer.parseInt(number) < 0 || Integer.parseInt(number) > 45)
                throw new IllegalArgumentException(ErrorType.OVER_WIN_NUMBER.getError());
        }
    }

    public static String inputBonusNumber() {
        System.out.println(TextType.BONUS_NUMBER_INPUT_MESSAGE.getText());

        String input = Console.readLine();

        return input;
    }

    public static void isValidBonusNumber(String bonusNumberInput) {

        isNumber(bonusNumberInput);

        if(Integer.parseInt(bonusNumberInput) < 0 || Integer.parseInt(bonusNumberInput) > 45)
            throw new IllegalArgumentException(ErrorType.OVER_BONUS_NUMBER.getError());
    }
}

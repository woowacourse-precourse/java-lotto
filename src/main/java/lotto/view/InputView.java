package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.type.ErrorType;
import lotto.type.TextType;

public class InputView {
    private static final String NUMBERS = "123456789";

    public static String inputPurchaseAmount() {
        System.out.println(TextType.PURCHASE_INPUT_MESSAGE.getText());

        String input = Console.readLine();

        return input;
    }

    public static void isNumber(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (!NUMBERS.contains(input.substring(i,i+1))) throw new IllegalArgumentException(ErrorType.NOT_NUMBER_INPUT.getError());
        }
    }

    public static void isValidUnit(int money) {
        int balance = money % 1000;
        if (balance > 0 || money < 0) throw new IllegalArgumentException(ErrorType.INVALID_UNIT.getError());
    }
}

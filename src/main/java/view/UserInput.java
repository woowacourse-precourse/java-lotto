package view;

import camp.nextstep.edu.missionutils.Console;
import model.ConstantMessage;
import model.ErrorMessage;

public class UserInput {
    private String input;

    public String inputWinningNumber() {
        System.out.println(ConstantMessage.INPUT_WINNING_NUMBER.getConstant());
        input = Console.readLine();
        validateWinningNumber(input);
        return input;
    }

    public String inputMoney() {
        System.out.println(ConstantMessage.INPUT_MONEY_MESSAGE.getConstant());
        input = Console.readLine();
        validateIsDigit(input);
        return input;
    }

    public String inputBonusNumber() {
        System.out.println(ConstantMessage.INPUT_BONUS_NUMBER.getConstant());
        input = Console.readLine();
        validateIsDigit(input);
        return input;
    }

    public void validateWinningNumber(String input) {
        if (!input.matches("([0-9]{1,3}\\,)*([0-9]{1,3})")) {
            throw new IllegalArgumentException(ErrorMessage.NOTDIGIT_NOTCOMMA.getErrorMessage());
        }
    }

    public void validateIsDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NOTDIGIT_ERROR_MESSAGE.getErrorMessage());
            }
        }
    }
}

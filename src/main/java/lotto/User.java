package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    public void inputMoney() {
        String money = Console.readLine();
        validateMoney(money);
    }

    public void inputWinningLottoNumbers() {
        String number = Console.readLine();

    }

    private void validateMoney(String money) {
        validateInputNothing(money);
        validateInputBlank(money);
        validateInputWithBlank(money);
        validateNumeric(money);
        validateMoreThan1000Won(money);
        validateMoneyDivided1000Won(money);
    }

    private void validateInputNothing(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(Error.INPUT_NOTHING.getMessage());
        }
    }

    private void validateInputBlank(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException(Error.INPUT_BLANK.getMessage());
        }
    }

    private void validateInputWithBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(Error.INPUT_WITH_BLACK.getMessage());
        }
    }

    private void validateNumeric(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException(Error.INPUT_NOT_NUMERIC.getMessage());
        }
    }

    private void validateMoreThan1000Won(String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException(Error.LESS_THAN_1000WON.getMessage());
        }
    }

    private void validateMoneyDivided1000Won(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(Error.NOT_DIVIDED_1000WON.getMessage());
        }
    }

    private void validateInputSixNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(Error.NOT_SIX_NUMBERS.getMessage());
        }
    }

    private void validateInputDuplicatedNumbers(String input) {
        Set<String> numbers = new HashSet<>(List.of(input.split(",")));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private void validateSeparator(String input) {
        String excludedSeparator = input.replace(",", "");
        if (input.length() - excludedSeparator.length() != 5) {
            throw new IllegalArgumentException(Error.SEPARATOR.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException(Error.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}

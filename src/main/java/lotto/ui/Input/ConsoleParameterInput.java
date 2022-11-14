package lotto.ui.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.WinningNumber;
import lotto.ui.text.ErrorText;
import lotto.ui.text.InputText;

public class ConsoleParameterInput implements ParameterInput {
    @Override
    public int readQuantityFromMoney() {
        try {
            int money = Integer.parseInt(Console.readLine());
            validateMoney(money);
            return money / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorText.NOT_NUMBER.toString());
        }
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorText.INVALID_MONEY_UNIT.toString());
        }
    }

    @Override
    public WinningNumber readWinningNumber() {
        List<Integer> basicNumbers = readBasicWinningNumber();

        System.out.println();

        int bonus = readBonusWinningNumber();

        return new WinningNumber(basicNumbers, bonus);
    }

    private List<Integer> readBasicWinningNumber() {
        try {
            System.out.println(InputText.INPUT_BASIC_WINNING_NUMBER);

            String basicNumberString = Console.readLine();

            return Arrays
                    .stream(basicNumberString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorText.NOT_NUMBER.toString());
        }
    }

    private int readBonusWinningNumber() {
        try {
            System.out.println(InputText.INPUT_BONUS_WINNING_NUMBER);

            String bonusNumber = Console.readLine();

            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorText.NOT_NUMBER.toString());
        }
    }
}

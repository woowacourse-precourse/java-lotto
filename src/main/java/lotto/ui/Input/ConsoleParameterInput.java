package lotto.ui.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.WinningNumber;
import lotto.ui.text.InputText;

public class ConsoleParameterInput implements ParameterInput {

    @Override
    public String read() {
        return Console.readLine();
    }

    @Override
    public int readQuantityFromMoney() {
        return 0;
    }

    public WinningNumber readWinningNumber() {
        System.out.println(InputText.INPUT_BASIC_WINNING_NUMBER);

        String basicNumberString = Console.readLine();
        List<Integer> basicNumbers = Arrays
                .stream(basicNumberString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();

        System.out.println(InputText.INPUT_BONUS_WINNING_NUMBER);
        String bonusNumber = Console.readLine();
        int bonus = Integer.parseInt(bonusNumber);

        return new WinningNumber(basicNumbers, bonus);
    }
}

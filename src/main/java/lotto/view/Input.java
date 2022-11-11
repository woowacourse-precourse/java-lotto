package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.ExceptionType;

public class Input {

    public Money getMoney() {
        String input = Console.readLine();
        int convertedInput = stringToInt(input);
        return new Money(convertedInput);
    }

    public Lotto getWinningLotto() {
        Lotto winningLotto = getWinningLottoNumbers();
        return winningLotto;
    }

    public Lotto getWinningLottoNumbers() {
        String input = Console.readLine();
        List<Integer> numbers = stringToIngerListByComma(input);
        return new Lotto(numbers);
    }

    private int stringToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            Output.printErrorAndExit(ExceptionType.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }

    private List<Integer> stringToIngerListByComma(String input) {
        List<Integer> returns = new ArrayList<>();
        String[] split = input.split(",");
        for(String number : split) {
            returns.add(stringToInt(number));
        }
        return returns;
    }
}

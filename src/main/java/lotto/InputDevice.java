package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDevice {

    private Validator validator = new Validator();

    public int sendMoneyToBuyLotto() {
        String money = Console.readLine();
        validator.validateMoney(money);
        return Integer.parseInt(money);
    }

    public List<Integer> sendWinningNumbers() {
        String input = Console.readLine();
        validator.validateWinningNumbers(input);
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int sendBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}

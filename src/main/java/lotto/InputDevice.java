package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDevice {

    public int sendMoneyToBuyLotto() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public List<Integer> sendWinningNumbers() {
        String input = Console.readLine();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

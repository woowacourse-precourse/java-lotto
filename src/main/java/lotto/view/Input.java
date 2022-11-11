package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int inputMoney() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumber() {
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}

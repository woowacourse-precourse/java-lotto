package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int inputCost() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {

        String[] s = Console.readLine().split(",");
        List<Integer> answer = Arrays.stream(s)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return answer;
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}

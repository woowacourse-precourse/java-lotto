package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputPrizeNumbers() {
        String numbers = Console.readLine();

        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}

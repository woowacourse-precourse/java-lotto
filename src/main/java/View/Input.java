package View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static int getPurchaseMoney() {
        return stringToInteger(Console.readLine());
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(number -> stringToInteger(number))
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public static int getBonusNumber() {
        return stringToInteger(Console.readLine());
    }

    public static int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}

package View;

import ExceptionCollections.WinningNumbersExeption;
import camp.nextstep.edu.missionutils.Console;
import enumCollections.Exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static String getPurchaseMoney() {
        return Console.readLine().trim();
    }

    public static List<Integer> getWinningNumbers() {
        List<String> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
        WinningNumbersExeption.validateWinningNumber(winningNumbers);
        return winningNumbers.stream().map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        return stringToInteger(Console.readLine());
    }

    public static int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}

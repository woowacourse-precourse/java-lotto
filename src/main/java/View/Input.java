package View;

import ExceptionCollections.WinningNumbersExeption;
import ExceptionCollections.BonusNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static String getPurchaseMoney() {
        return Console.readLine().trim();
    }

    public static List<Integer> getWinningNumbers() {
        List<String> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
        WinningNumbersExeption.validateWinningNumber(winningNumbers);
        return winningNumbers.stream()
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String bonusNumber = Console.readLine();
        BonusNumberException.validateNumber(winningNumbers, bonusNumber);
        return Integer.valueOf(bonusNumber);
    }
}

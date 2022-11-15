package View;

import ExceptionCollections.BonusNumberException;
import ExceptionCollections.PaymentException;
import ExceptionCollections.WinningNumbersExeption;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static int getPayment() {
        String payment = Console.readLine().trim();
        PaymentException.validate(payment);
        return Integer.valueOf(payment);
    }

    public static List<Integer> getWinningNumbers() {
        List<String> winningNumbers = Arrays
                .stream(Console.readLine().trim().split(","))
                .collect(Collectors.toList());
        WinningNumbersExeption.validate(winningNumbers);
        return winningNumbers.stream()
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String bonusNumber = Console.readLine().trim();
        BonusNumberException.validate(winningNumbers, bonusNumber);
        return Integer.valueOf(bonusNumber);
    }
}

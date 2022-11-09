package lotto.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static void setBonusNumber(int bonusNumber) {
        Lotto.bonusNumber = bonusNumber;
    }

    public static void stringToList(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        winningNumbers = convertTypeStringToInteger(numbers);
    }

    private static List<Integer> convertTypeStringToInteger(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        winningNumbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}

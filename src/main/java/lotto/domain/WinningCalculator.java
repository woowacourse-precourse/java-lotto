package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.UserInterface;

public class WinningCalculator {
    private static List<Integer> numbers;
    private static int bonusNumber;

    public static void setWinningRule() {
        setNumbersFromUser();
        setBonusNumberFromUser();
    }

    private static void setNumbersFromUser() {
        String numbersRaw = UserInterface.getWinningNumbers();
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        numbers = winningNumbers;
    }

    private static List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }

    private static void setBonusNumberFromUser() {
        String bonusNumberRaw = UserInterface.getBonusNumber();
        int bonusNumberConverted = Integer.parseInt(bonusNumberRaw);
        bonusNumber = bonusNumberConverted;
    }
}

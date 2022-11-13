package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.UserInterface;

public class WinningCalculator {
    private List<Integer> numbers;
    private int bonusNumber;

    public void setWinningRule() {
        setNumbersFromUser();
        setBonusNumberFromUser();
    }

    private void setNumbersFromUser() {
        String numbersRaw = UserInterface.getWinningNumbers();
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        numbers = winningNumbers;
    }

    private List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }

    private void setBonusNumberFromUser() {
        String bonusNumberRaw = UserInterface.getBonusNumber();
        int bonusNumberConverted = Integer.parseInt(bonusNumberRaw);
        bonusNumber = bonusNumberConverted;
    }
}

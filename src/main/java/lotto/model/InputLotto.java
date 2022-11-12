package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorControl;

public class InputLotto {
    public double money;
    public List<Integer> winNumbers;
    public int bonusNumber;
    ErrorControl errorControl = new ErrorControl();

    public void inputMoney() {
        String input = Console.readLine();
        errorControl.validateNumber(input);
        money = errorControl.validateDivideThousand(Double.parseDouble(input));
    }

    public void inputWinNumber() {
        String input = Console.readLine();
        winNumbers = convertToWinNumbers(input);
    }

    List<Integer> convertToWinNumbers(String input) {
        List<Integer> winNumbers = new ArrayList<>(6);
        String[] splitInput = input.split(",");
        errorControl.validateSeparatorAndSize(splitInput);

        for (String number : splitInput) {
            errorControl.validateNumberInRange(number);
            winNumbers.add(errorControl.validateDuplicateNumber(winNumbers, Integer.parseInt(number)));
        }
        return winNumbers;
    }

    public void inputBonusNumber(List<Integer> winNumbers) {
        String input = Console.readLine();
        bonusNumber = convertToBonusNumber(input, winNumbers);
    }

    int convertToBonusNumber(String input, List<Integer> winNumbers) {
        errorControl.validateNumberInRange(input);
        int bonusNumber = Integer.parseInt(input);
        errorControl.validateDuplicateNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }
}
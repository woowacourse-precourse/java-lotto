package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorControl;

public class InputLotto {
    private double money;
    ErrorControl errorControl = new ErrorControl();

    public void inputMoney() {
        String input = Console.readLine();
        errorControl.validateNumber(input);
        money = errorControl.validateDivideThousand(Double.parseDouble(input));
    }

    public LottoData makeLottoData() {
        return new LottoData(money);
    }

    public void inputWinNumber(LottoData lottoData) {
        String input = Console.readLine();
        List<Integer> winNumbers = convertToWinNumbers(input);
        lottoData.saveWinNumbers(winNumbers);
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

    public void inputBonusNumber(LottoData lottoData, List<Integer> winNumbers) {
        String input = Console.readLine();
        int bonusNumber = convertToBonusNumber(input, winNumbers);
        lottoData.saveBonusNumber(bonusNumber);
    }

    int convertToBonusNumber(String input, List<Integer> winNumbers) {
        errorControl.validateNumberInRange(input);
        int bonusNumber = Integer.parseInt(input);
        errorControl.validateDuplicateNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }
}
package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Constants;
import lotto.ErrorControl;

public class InputLotto {
    private double money;

    public void inputMoney() {
        String input = Console.readLine();
        ErrorControl.validateNumber(input);
        money = ErrorControl.validateDivideThousand(Double.parseDouble(input));
    }

    public LottoData makeLottoData() {
        return new LottoData(money);
    }

    public void inputWinNumber(LottoData lottoData) {
        String input = Console.readLine();
        List<Integer> winNumbers = convertToWinNumbers(input);
        lottoData.saveWinNumbers(winNumbers);
    }

    private List<Integer> convertToWinNumbers(String input) {
        List<Integer> winNumbers = new ArrayList<>(Constants.LOTTO_SIZE);
        ErrorControl.validateNumberOfSeparate(input);
        String[] splitInput = input.split(Constants.NUMBER_SEPARATOR);
        ErrorControl.validateSeparatorAndSize(splitInput);

        for (String number : splitInput) {
            ErrorControl.validateNumberInRange(number);
            winNumbers.add(ErrorControl.validateDuplicateNumber(winNumbers, Integer.parseInt(number)));
        }
        return winNumbers;
    }

    public void inputBonusNumber(LottoData lottoData, List<Integer> winNumbers) {
        String input = Console.readLine();
        int bonusNumber = convertToBonusNumber(input, winNumbers);
        lottoData.saveBonusNumber(bonusNumber);
    }

    private int convertToBonusNumber(String input, List<Integer> winNumbers) {
        ErrorControl.validateNumberInRange(input);
        int bonusNumber = Integer.parseInt(input);
        ErrorControl.validateDuplicateNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }
}
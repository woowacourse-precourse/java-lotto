package lotto.model;

import java.util.List;
import lotto.constants.ErrorCode;

public class BonusNumber {

    int bonusNumber;

    public BonusNumber(Lotto lotto, String  inputString) {
        int inputNumber = stringToInt(inputString);
        validateContains(lotto, inputNumber);
        this.bonusNumber = inputNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int stringToInt(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.valueOf(input);
        } catch (Exception e) {
            throw ErrorCode.NOT_NUMBER.getException();
        }
        return inputNumber;
    }

    private void validateContains(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw ErrorCode.NOT_CONTAINS_IN_LOTTO.getException();
        }
    }
}

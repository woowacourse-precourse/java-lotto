package lotto.domain;

import lotto.enums.ErrorMessage;

import java.util.List;

public class LottoAnswer extends Lotto{
    private final int bonusNumber;

    public LottoAnswer(List<Integer> numbers, String bonusNumber) {
        super(numbers);
        bonusNumberCheck(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
        bonusNumberValidate(numbers, this.bonusNumber);
    }

    private void bonusNumberCheck(String bonusNumber) {
        for (char ch : bonusNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
            }
        }
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    public void bonusNumberValidate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_LOTTO_ANSWER_SAME_NUMBER.getErrorMessage());
        }
        numberMaxMinCheck(bonusNumber);
    }
}

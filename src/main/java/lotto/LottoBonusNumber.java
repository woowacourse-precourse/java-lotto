package lotto;

import java.util.List;

import static lotto.Lotto.LOTTO_NUMBER_LENGTH_ZERO;

public class LottoBonusNumber {

    private static final String WINNING_NUMBER_SPACE = " ";

    private final int bonusNumber;

    public LottoBonusNumber(String bonusNumber) {
        this.bonusNumber = validate(bonusNumber);
    }

    public boolean isBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }

    private int validate(String bonusNumber) {
        validateEmpty(bonusNumber);
        validateBlank(bonusNumber);
        int newBonusNumber = validateBonusNumberType(bonusNumber);
        validateNumberSize(newBonusNumber);
        return newBonusNumber;
    }

    private void validateEmpty(String bonusNumber) {
        if (bonusNumber.length() == LOTTO_NUMBER_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String bonusNumber) {
        if (bonusNumber.contains(WINNING_NUMBER_SPACE)) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private int validateBonusNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호는 숫자가 아닙니다.");
        }
    }

    private void validateNumberSize(int number) {
        if (number > LottoFactory.END_INCLUSIVE) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호는 숫자가 너무 큽니다");
        }
        if (number < LottoFactory.START_INCLUSIVE) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호는 숫자가 너무 작습니다");
        }
    }

}

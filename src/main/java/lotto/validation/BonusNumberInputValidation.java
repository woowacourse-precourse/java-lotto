package lotto.validation;

import java.util.List;

public class BonusNumberInputValidation {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public void validate(List<Integer> predictionNumbers, String inputBonusNumber) {
        validateInputIsInteger(inputBonusNumber);
        validateNoDuplicationWithPredictionNumbers(predictionNumbers, inputBonusNumber);
        validateNumberRange(inputBonusNumber);
    }

    public void validateInputIsInteger(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public void validateNoDuplicationWithPredictionNumbers(List<Integer> predictionNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (predictionNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 예측 번호와 중복되는 번호를 입력할 수 없습니다.");
        }
    }

    public void validateNumberRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 번호의 범위는 1이상 45이하여야 합니다.");
        }
    }
}

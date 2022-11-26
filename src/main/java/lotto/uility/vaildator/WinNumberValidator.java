package lotto.uility.vaildator;

import java.util.List;


public class WinNumberValidator {

    public void validateNumbers(List<Integer> winNumbers, int bonusNumber) {
        if (duplicateNumber(winNumbers)) {
            throw new IllegalArgumentException(ValidateConstants.DUPLICATE_NUMBER_VALIDATION);
        } else if (rangOutNumber(winNumbers)) {
            throw new IllegalArgumentException(ValidateConstants.NUMBER_RANGE_VALIDATION);
        } else if(sizeNumber(winNumbers)) {
            throw new IllegalArgumentException(ValidateConstants.SIZE_VALIDATION);
        } else if(bonusNumberIsDuplicate(winNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ValidateConstants.BONUSNUMBER_DUPLICATE);
        }
    }

    private boolean bonusNumberIsDuplicate(List<Integer> winNumbers, int bonusNumber) {
        if(winNumbers.contains(bonusNumber)) return true;
        return false;
    }

    private boolean sizeNumber(List<Integer> winNumbers) {
        if(winNumbers.size() != ValidateConstants.LOTTO_SIZE) return true;
        return false;
    }

    private boolean rangOutNumber(List<Integer> winNumbers) {
        for (int number : winNumbers) {
            if (number < ValidateConstants.MIN_NUMBER || number > ValidateConstants.MAX_NUMBER) {
                return true;
            }
        }
        return false;
    }

    private boolean duplicateNumber(List<Integer> winNumbers) {
        if (winNumbers.size() != winNumbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

}

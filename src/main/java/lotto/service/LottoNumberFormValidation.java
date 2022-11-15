package lotto.service;

import lotto.exception.ErrorCode;

public class LottoNumberFormValidation {

    public void blankIncludeValid(String writeLottoNumber, String writeBonusNumber) {
        if (isIncludeBlank(writeLottoNumber) || isIncludeBlank(writeBonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isIncludeBlank(String writeLottoNumber) {
        return writeLottoNumber.chars().anyMatch(value -> value == ' ');
    }

    public int getValidBonusNumber(String writeBonusNumber) {
        digitValid(writeBonusNumber);
        int bonusNumber = Integer.parseInt(writeBonusNumber);
        rangeNumberValid(bonusNumber);
        return bonusNumber;
    }

    private void digitValid(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    private void rangeNumberValid(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

}

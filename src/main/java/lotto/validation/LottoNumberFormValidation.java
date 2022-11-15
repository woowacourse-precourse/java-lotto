package lotto.validation;

import lotto.exception.ErrorCode;

import java.util.List;

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

    private void digitValid(String writeBonusNumber) {
        if (!isDigit(writeBonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private void rangeNumberValid(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isDigit(String writeBonusNumber) {
        return writeBonusNumber.chars().allMatch(Character::isDigit);
    }

    public void countValid(List<Integer> numbers) {
        int currentCount = numbers.size();
        int distinctCount = (int) numbers.stream().distinct().count();

        numberCountValid(currentCount);
        duplicateValid(currentCount, distinctCount);
    }

    private void numberCountValid(int currentCount) {
        if (currentCount != 6) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private void duplicateValid(int currentCount, int distinctCount) {
        if (currentCount != distinctCount) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }
}

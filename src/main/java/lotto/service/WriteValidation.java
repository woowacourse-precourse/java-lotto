package lotto.service;

import lotto.dto.WinningLottoNumber;
import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriteValidation {

    private void validWrite(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    // 당첨 로또 입력 기능
    public WinningLottoNumber writeWinningLottoNumbers(String writeLottoNumber, String writeBonusNumber) {
        if (writeLottoNumber.chars().anyMatch(value -> value == ' ') || writeBonusNumber.chars().anyMatch(value -> value == ' ')) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }

        List<Integer> winningNumbers = Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        validWinningNumbers(winningNumbers);
        int bonusNumber = getValidBonusNumber(writeBonusNumber);

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        if (!isNumberCount(winningNumbers) && !isNumberRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }

        validDuplicate(winningNumbers);
    }

    private boolean isNumberCount(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    private boolean isNumberRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private void validDuplicate(List<Integer> winningNumbers) {
        int currentSize = winningNumbers.size();
        int distinctSize = (int) winningNumbers.stream().distinct().count();

        if (currentSize != distinctSize) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private int getValidBonusNumber(String writeBonusNumber) {
        validWrite(writeBonusNumber);
        int bonusNumber = Integer.parseInt(writeBonusNumber);
        validRangeNumber(bonusNumber);
        return bonusNumber;
    }

    private void validRangeNumber(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }
}

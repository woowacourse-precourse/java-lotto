package lotto.service;

import lotto.dto.WinningLottoNumber;
import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriteValidation {

    public WinningLottoNumber writeWinningLottoNumbers(String writeLottoNumber, String writeBonusNumber) {
        if (writeLottoNumber.chars().anyMatch(value -> value == ' ') || writeBonusNumber.chars().anyMatch(value -> value == ' ')) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }

        List<Integer> winningNumbers = Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int bonusNumber = getValidBonusNumber(writeBonusNumber);

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }

    private int getValidBonusNumber(String writeBonusNumber) {
        validWrite(writeBonusNumber);
        int bonusNumber = Integer.parseInt(writeBonusNumber);
        validRangeNumber(bonusNumber);
        return bonusNumber;
    }

    private void validWrite(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    private void validRangeNumber(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }
}

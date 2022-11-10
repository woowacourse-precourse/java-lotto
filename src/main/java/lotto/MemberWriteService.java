package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberWriteService {

    // 금액 입력 기능
    public int writePay(String writePay) {
        // 사용자가 잘못 입력한 시 IllegalArgumentException 발생
        validWrite(writePay);
        return Integer.parseInt(writePay);
    }

    private void validWrite(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    // 당첨 로또 입력 기능
    public WinningLottoNumber writeWinningLottoNumbers(String writeLottoNumber, String writeBonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        validWinningNumbers(winningNumbers);
        int bonusNumber = getValidBonusNumber(writeBonusNumber);

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        if (!isNumberCount(winningNumbers) && !isNumberRange(winningNumbers)) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
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
            throw new IllegalArgumentException("This Lotto Number is Duplicated Exception !!");
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
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }
    }
}

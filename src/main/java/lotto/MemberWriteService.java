package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberWriteService {

    // 금액 입력 기능
    public int writePay(String writePay) {
        // 사용자가 잘못 입력한 시 IllegalArgumentException 발생
        validWritePay(writePay);
        return Integer.parseInt(writePay);
    }

    private void validWritePay(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }
    }

    private boolean isDigit(String writePay) {
        return writePay.chars().allMatch(Character::isDigit);
    }

    // 당첨 로또 입력 기능
    public WinningLottoNumber winningLottoNumbers(String writeLottoNumber, String writeBonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        validWinningNumbers(winningNumbers);

        int bonusNumber = 0;
        bonusNumber = getValidBonusNumber(writeBonusNumber, bonusNumber);

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        if (!(isNumberCount(winningNumbers) && isNumberRange(winningNumbers))) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }
    }

    private boolean isNumberCount(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    private boolean isNumberRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private int getValidBonusNumber(String writeBonusNumber, int bonusNumber) {
        try {
            bonusNumber = Integer.parseInt(writeBonusNumber);
            rangeValidBonusNumber(bonusNumber);

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return 0;
        }

        return bonusNumber;
    }

    private void rangeValidBonusNumber(int bonusNumber) {
        if (bonusNumber >=1 && bonusNumber <= 45) {
            throw new IllegalArgumentException("This Lotto Number is Exception !!");
        }
    }
}

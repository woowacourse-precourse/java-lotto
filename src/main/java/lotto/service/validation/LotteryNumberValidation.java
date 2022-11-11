package lotto.service.validation;

import java.util.List;

public class LotteryNumberValidation {

    List<Integer> winningNumbers;

    public LotteryNumberValidation(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    /*
     * 당첨 숫자 예외 사항
     * 1. 각각 숫자가 1-45 범위를 벗어나는 경우
     * 2. 총 인자 개수가 6개가 아닌 경우
     */

    public boolean isValidWinningNumbers() {
        return checkSize() && assertEachNumberSatisfyRange();
    }


    public boolean isValidBonusNumber(int bonusNumber) {
        return isRightRange(bonusNumber) && includesWinningNumbers(bonusNumber);
    }


    private boolean checkSize() {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }

    private boolean assertEachNumberSatisfyRange() {
        return winningNumbers.stream().anyMatch(this::isRightRange);
    }


    /*
     * 보너스 넘버 예외사항:
     * 1. 당첨 번호에 포함된 숫자를 뽑는 경우 (O)
     * 2. 숫자가 1-45 범위가 아닌 경우 (O)
     * 3. 2개 이상 값이 들어오는 경우 -> controller 영역에서 에러 핸들링
     * 4. 숫자 외 값이 들어올 경우 -> controller 영역에서 에러 핸들링
     */


    private boolean isRightRange(int number) {
        return number <= MAX_LOTTO_NUMBER && number >= MIN_LOTTO_NUMBER;
    }

    private boolean includesWinningNumbers(int number) {
        return !winningNumbers.contains(number);
    }
}

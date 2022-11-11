package lotto.service.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * 3. 중복된 숫자를 가지고 있으면 false
     */

    public boolean isValidWinningNumbers() {
        return checkSize() && assertEachNumberSatisfyRange() && hasUniqueNumbers();
    }

    public boolean isValidBonusNumber(int bonusNumber) {
        return isRightRange(bonusNumber) && includesWinningNumbers(bonusNumber);
    }


    private boolean checkSize() {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }

    private boolean assertEachNumberSatisfyRange() {
        return winningNumbers.stream().allMatch(this::isRightRange);
    }

    private boolean hasUniqueNumbers() {
        final Set<Integer> uniques = new HashSet<Integer>();
        for(Integer number: winningNumbers) {
            if(!uniques.add(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightRange(int number) {
        return number <= MAX_LOTTO_NUMBER && number >= MIN_LOTTO_NUMBER;
    }

    private boolean includesWinningNumbers(int number) {
        return !winningNumbers.contains(number);
    }
}

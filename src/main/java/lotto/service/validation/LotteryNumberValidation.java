package lotto.service.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumberValidation {

    private final List<Integer> winningNumbers;

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
     * 4. 숫자 외
     */

    public boolean isValidWinningNumbers() {
        if (!checkSize()) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다. 숫자 개수를 올바르게 입력해주세요.");
        }

        if (!assertEachNumberSatisfyRange()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (!hasUniqueNumbers()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
        return true;
    }

    public boolean isValidBonusNumber(int bonusNumber) {
        if (!isRightRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (!includesWinningNumbers(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또번호에 포함되지 않은 값이어야 합니다.");
        }
        return true;
    }


    private boolean checkSize() {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }

    private boolean assertEachNumberSatisfyRange() {
        return winningNumbers.stream().allMatch(this::isRightRange);
    }

    private boolean hasUniqueNumbers() {
        final Set<Integer> uniques = new HashSet<>();
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

package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;
    public static final int MAX_LOTTO_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Lotto(List<Integer> winningNumbers, int bonusNumber) {
        validateLotto(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLotto(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이뤄져야 합니다!");
        }
        if (checkDuplicate(winningNumbers)) {
            throw new IllegalArgumentException("중복되는 숫자가 포함되어 있습니다!");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 6자리에 포함되어 있습니다!");
        }
        validArrangeLottoNum(bonusNumber);
        for (Integer winningNumber : winningNumbers) {
            validArrangeLottoNum(winningNumber);
        }
    }

    private void validArrangeLottoNum(int bonusNumber) {
        if (bonusNumber > LOTTO_MAX_NUM || bonusNumber < LOTTO_MIN_NUM) {
            throw new IllegalArgumentException("1부터 45까지의 자연수만 입력해주세요!");
        }
    }

    private boolean checkDuplicate(List<Integer> winningNumbers) {
        HashSet<Integer> winningNumSet = new HashSet<>(winningNumbers);
        return winningNumbers.size() > winningNumSet.size();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

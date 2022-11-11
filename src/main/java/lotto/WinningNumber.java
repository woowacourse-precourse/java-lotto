package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;

    public WinningNumber(List<Integer> winningNum) {
        validateLottoNum(winningNum);
        this.winningNum = winningNum;

    }

    public WinningNumber(int bonusNum) {
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateLottoNum(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException();
        }

        for (int num: winningNum) {
            if (bonusNum < 1 || bonusNum >45) {
                throw new IllegalArgumentException();
            }
        }

        Set<Integer> notDuplicated = new HashSet<>(winningNum);
        if (winningNum.size() != notDuplicated.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum >45) {
            throw new IllegalArgumentException();
        }
    }
}

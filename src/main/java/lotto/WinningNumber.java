package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;

    public WinningNumber(List<Integer> winningNum, int bonusNum) {
        validateLottoNum(winningNum);
        this.winningNum = winningNum;
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateLottoNum(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 크기는 6이어야 합니다.");
        }

        for (int num: winningNum) {
            if (num < 1 || num >45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45사이의 수여야 합니다.");
            }
        }

        Set<Integer> notDuplicated = new HashSet<>(winningNum);
        if (winningNum.size() != notDuplicated.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되는 수가 없어야 합니다.");
        }
    }

    private void validateBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum >45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45사이의 수여야 합니다.");
        }

        if (winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 없는 수여야 합니다.");
        }
    }

    public List<Integer> getWinningNum() {
        return winningNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

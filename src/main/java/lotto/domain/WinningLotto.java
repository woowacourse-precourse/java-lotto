package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLotto = new ArrayList<>();
    private final int bonusNum;

    public WinningLotto(String winningInput, int bonusNumInput) {
        validateWinningInput(winningInput);
        validateBonusNumInput(bonusNumInput);

        for (String s : winningInput.split(",")) {
            winningLotto.add(Integer.valueOf(s));
        }

        bonusNum = bonusNumInput;
    }

    private void validateWinningInput(String winningInput) {

    }

    private void validateBonusNumInput(int bonusNumInput) {

    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

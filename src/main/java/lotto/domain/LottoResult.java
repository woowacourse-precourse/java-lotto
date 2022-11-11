package lotto.domain;

import java.util.List;

public class LottoResult {
    // winningNumbers, playerNumbers, bonusNumbers => match, bonusMatch => Rank에 전달
    private int match;
    private int bonusMatch;

    public LottoResult(List<Integer> winningNumbers, List<Integer> playerNumbers, int bonusNumber) {
        for (Integer playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                match++;
                if (match == 5 && playerNumbers.contains(bonusNumber)) {
                    bonusMatch++;
                }
            }
        }
        match -= bonusMatch;
    }

    public int getMatch() {
        return match;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }
}

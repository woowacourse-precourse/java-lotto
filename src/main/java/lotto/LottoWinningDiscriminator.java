package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoRank.*;

public class LottoWinningDiscriminator {
    private final List<Integer> winningNumber;
    private final Integer bonusNumber;

    public LottoWinningDiscriminator(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> discriminate(List<Lotto> purchasedLotto) {
        List<LottoRank> result = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            int correctWinningNumber = countCorrectWinningNumber(lotto);
            boolean correctBonusNumber = isCorrectBonusNumber(lotto);
            result.add(winningResult(correctWinningNumber, correctBonusNumber));
        }
        return result;
    }

    private int countCorrectWinningNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumber.contains(number))
                .count();
    }

    private boolean isCorrectBonusNumber(Lotto lotto) {
        return lotto.getNumbers().stream()
                .anyMatch(number -> bonusNumber.equals(number));
    }
}

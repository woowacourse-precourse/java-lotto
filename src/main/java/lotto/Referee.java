package lotto;

import static lotto.WinningType.FIVE_WITH_BONUS_MATCH;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final Judgement judgement;

    public Referee() {
        judgement = new Judgement();
    }

    public List<WinningType> compare(List<Lotto> lottos, List<Integer> player, int bonusNumber) {
        List<WinningType> winningTypes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);

            WinningType winningType = WinningType.findByCorrectCount(correctCount);

            if (checkBonusNumber(winningType, lotto, bonusNumber)) {
                winningType = FIVE_WITH_BONUS_MATCH;
            }

            winningTypes.add(winningType);
        }

        return winningTypes;
    }

    public boolean checkBonusNumber(WinningType winningType, Lotto lotto, int bonusNumber) {
        boolean fiveMatch = winningType.isFiveMatch();
        boolean bonusNumberMatch = isBonusNumberMatch(lotto, bonusNumber);

        return fiveMatch && bonusNumberMatch;
    }

    public boolean isBonusNumberMatch(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.contains(bonusNumber);
    }
}
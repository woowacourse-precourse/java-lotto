package lotto;

import static lotto.WinningType.FIVE_MATCH;
import static lotto.WinningType.FIVE_WITH_BONUS_MATCH;
import static lotto.WinningType.FOUR_MATCH;
import static lotto.WinningType.SIX_MATCH;
import static lotto.WinningType.THREE_MATCH;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final Judgement judgement;

    public Referee() {
        judgement = new Judgement();
    }

    public int countThreeMatch(List<Lotto> lottos, List<Integer> player) {
        int count = 0;

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);
            boolean isThreeMatch = correctCount == THREE_MATCH.getMatchCount();
            if (isThreeMatch) {
                count++;
            }
        }

        return count;
    }

    public int countFourMatch(List<Lotto> lottos, List<Integer> player) {
        int count = 0;

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);
            boolean isFourMatch = correctCount == FOUR_MATCH.getMatchCount();
            if (isFourMatch) {
                count++;
            }
        }

        return count;
    }

    public int countFiveMatch(List<Lotto> lottos, List<Integer> player) {
        int count = 0;

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);
            boolean isOnlyFiveMatch = correctCount == FIVE_MATCH.getMatchCount();
            if (isOnlyFiveMatch) {
                count++;
            }
        }

        return count;
    }

    public boolean isBonusNumberMatch(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.contains(bonusNumber);
    }

    public boolean isFiveMatch(Lotto lotto, List<Integer> player) {
        int correctCount = judgement.correctCount(lotto, player);

        return  correctCount == FIVE_WITH_BONUS_MATCH.getMatchCount();
    }

    public int countFiveMatchWithBonusNumber(List<Lotto> lottos, List<Integer> player, int bonusNumber) {
        int count = 0;

        for (Lotto lotto : lottos) {
            boolean isFiveMatch = isFiveMatch(lotto, player);
            boolean isBonusNumberMatch = isBonusNumberMatch(lotto, bonusNumber);

            if (isFiveMatch && isBonusNumberMatch) {
                count++;
            }
        }

        return count;
    }

    public int countSixMatch(List<Lotto> lottos, List<Integer> player) {
        int count = 0;

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);
            boolean isSixMatch = correctCount == SIX_MATCH.getMatchCount();
            if (isSixMatch) {
                count++;
            }
        }

        return count;
    }
}

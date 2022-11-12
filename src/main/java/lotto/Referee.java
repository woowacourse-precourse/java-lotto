package lotto;

import static lotto.MatchingType.FIVE_WITH_BONUS_MATCH;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final Judgement judgement;

    public Referee() {
        judgement = new Judgement();
    }

    public List<MatchingType> compare(List<Lotto> lottos, List<Integer> player, int bonusNumber) {
        List<MatchingType> matchingTypes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int correctCount = judgement.correctCount(lotto, player);

            MatchingType matchingType = MatchingType.findByCorrectCount(correctCount);

            if (checkBonusNumber(matchingType, lotto, bonusNumber)) {
                matchingType = FIVE_WITH_BONUS_MATCH;
            }

            matchingTypes.add(matchingType);
        }

        return matchingTypes;
    }

    public boolean checkBonusNumber(MatchingType matchingType, Lotto lotto, int bonusNumber) {
        boolean fiveMatch = matchingType.isFiveMatch();
        boolean bonusNumberMatch = isBonusNumberMatch(lotto, bonusNumber);

        return fiveMatch && bonusNumberMatch;
    }

    public boolean isBonusNumberMatch(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.contains(bonusNumber);
    }
}
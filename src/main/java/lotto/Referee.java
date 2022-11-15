package lotto;

import static lotto.MatchingType.FIVE_WITH_BONUS_MATCH;
import static lotto.MatchingType.NOT_MATCH;
import static lotto.constant.NumberConstant.ZERO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {

    private final Judgement judgement;
    private final List<WinningStat> result;

    public Referee() {
        judgement = new Judgement();
        result = initializingResult();
    }

    public List<WinningStat> initializingResult() {
        List<WinningStat> result = new ArrayList<>();

        Arrays.stream(MatchingType.values())
                .filter(matchingType -> matchingType != NOT_MATCH)
                .forEach(matchingType ->
                        result.add(new WinningStat(matchingType, ZERO.getValue())));

        return result;
    }

    public List<WinningStat> compare(List<Lotto> lottos, List<Integer> player, int bonusNumber) {
        for (Lotto lotto : lottos) {
            MatchingType matchingType = createMatchingType(lotto, player, bonusNumber);

            if (matchingType.isWinningType()) {
                calculateStat(matchingType);
            }
        }

        return result;
    }

    public MatchingType createMatchingType(Lotto lotto, List<Integer> player, int bonusNumber) {
        int correctCount = judgement.correctCount(lotto, player);

        MatchingType matchingType = MatchingType.findByCorrectCount(correctCount);

        if (checkBonusNumber(matchingType, lotto, bonusNumber)) {
            matchingType = FIVE_WITH_BONUS_MATCH;
        }

        return matchingType;
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

    public void calculateStat(MatchingType matchingType) {
        result.stream()
                .filter(winningStat ->
                        winningStat.getMatchingType() == matchingType)
                .findAny()
                .ifPresent(WinningStat::addCount);
    }

    public List<WinningStat> getResult() {
        return result;
    }
}
package lotto.domain;

import lotto.validation.Validator;

import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers, LOTTO_SIZE);
        Validator.validateNonDuplicatedList(numbers);
        Validator.validateNumbersRange(numbers, LOTTO_START_RANGE, LOTTO_END_RANGE);
    }

    public String getNumbersString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public RankingType getRankingType(WinningLotto winningLotto){
        int matchingPoint = getMatchingPoint(winningLotto);

        RankingType rankingTypeCandidate =
                getRankingTypeCandidate(matchingPoint);

        if(rankingTypeCandidate == RankingType.SECOND || rankingTypeCandidate == RankingType.THIRD){
            rankingTypeCandidate = determineSecondOrThird(winningLotto);
        }

        return rankingTypeCandidate;
    }

    private int getMatchingPoint(WinningLotto winningNumber) {
        int matchingPoint = INIT_MATCHING_POINT;
        for (Integer number : numbers) {
            matchingPoint += getExtraMatchingPoint(number, winningNumber);
        }
        return matchingPoint;
    }


    private int getExtraMatchingPoint(int number, WinningLotto winningLotto){
        if(winningLotto.contains(number)){
            return EXTRA_POINT_WHEN_MATCH;
        }
        return EXTRA_POINT_WHEN_MISMATCH;
    }

    private static RankingType getRankingTypeCandidate(int matchingPoint) {
        for (RankingType rankingType : RankingType.values()) {
            if(matchingPoint == rankingType.getCondition()){
                return rankingType;
            }
        }
        return RankingType.DROP_OUT;
    }

    private RankingType determineSecondOrThird(WinningLotto winningLotto) {
        if(isMatchWithBonus(winningLotto)){
            return RankingType.SECOND;
        }
        return RankingType.THIRD;
    }

    private boolean isMatchWithBonus(WinningLotto winningLotto){
        for (Integer number : numbers) {
            if(winningLotto.isBonusEqualTo(number)){
                return true;
            }
        }
        return false;
    }
}

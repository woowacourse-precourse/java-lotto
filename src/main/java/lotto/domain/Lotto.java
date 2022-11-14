package lotto.domain;

import lotto.validation.Validator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers, 6);
        Validator.validateNonDuplicatedList(numbers);
        Validator.validateNumbersRange(numbers, 1, 45);
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
        int matchingPoint = 0;
        for (Integer number : numbers) {
            matchingPoint += getExtraMatchingPoint(number, winningNumber);
        }
        return matchingPoint;
    }


    private int getExtraMatchingPoint(int number, WinningLotto winningLotto){
        if(winningLotto.contains(number)){
            return 1;
        }
        return 0;
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

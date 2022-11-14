package lotto.domain;

public class Ranking {

    public RankingType getRanking(Lotto userLotto, WinningLotto winningNumber){
        ScoreCalculator calculator = new ScoreCalculator();
        calculator.updateScore(userLotto, winningNumber);
        int matchingScore = calculator.getMatching();
        boolean matchingBonus = calculator.isMatchingBonus();
        if(matchingScore == 6){
            return RankingType.FIRST;
        }
        if(matchingScore == 5 && matchingBonus){
            return RankingType.SECOND;
        }
        if(matchingScore == 5){
            return RankingType.THIRD;
        }
        if(matchingScore == 4){
            return RankingType.FOURTH;
        }
        if(matchingScore == 3){
            return RankingType.FIFTH;
        }
        return RankingType.DROP_OUT;
    }
}

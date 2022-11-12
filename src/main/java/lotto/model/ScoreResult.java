package lotto.model;

import java.util.List;

import static lotto.model.MatchScore.Nothing;
import static lotto.model.MatchScore.Three;
import static lotto.model.MatchScore.Four;
import static lotto.model.MatchScore.Five;
import static lotto.model.MatchScore.FiveAndBonus;
import static lotto.model.MatchScore.Six;


public class ScoreResult{
    private static final List<MatchScore> matchScores=List.of(Nothing, Nothing, Nothing, Three, Four, Five, Six);
    public ScoreResult(){
    }

    private int getScore(List<Integer> computer, List<Integer> user){
        int count=0;
        for(int i=0; i<computer.size(); i++){
            if(user.contains(computer.get(i))){
                count++;
            }
        }
        return count;
    }
}
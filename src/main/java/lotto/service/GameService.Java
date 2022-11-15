package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.utils.RewardType;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.RewardType.getRating;


public class GameService {

    public static int winNum;
    public static boolean bonusNum;
    public static List<Integer> score;
    //당첨 내역 및 수익률 출력

    public void init(){
        score = Arrays.asList(0,0,0,0,0,0);
    }
    public static int winLotto(Lotto Lotto, User User){
        int count=0;
        for (int i = 0; i<6; i++){
            if (Lotto.contains(User.get_index(i))){
                count+=1;
            }
        }
        return count;
    }

    public static boolean bonusBall(Lotto Lotto, int bonusNum){
        for (int i=0; i<6; i++){
            if (Lotto.contains(bonusNum)){
                return true;
            }
        }
        return false;
    }

    public static void getResult(int matchNum, boolean containBonusBall){
        RewardType Reward = getRating(matchNum, containBonusBall);

        if (Reward==RewardType.FIRST){score.set(5,score.get(5)+1);};
        if (Reward==RewardType.SECOND){score.set(4,score.get(4)+1);};
        if (Reward==RewardType.THIRD){score.set(3,score.get(3)+1);};
        if (Reward==RewardType.FOURTH){score.set(2,score.get(2)+1);};
        if (Reward==RewardType.FIFTH){score.set(1,score.get(1)+1);};
        if (Reward==RewardType.MISS){score.set(0,score.get(0)+1);};
    }

    public static List<Integer> getFinalResult(){
        return score;
    }
}


package lotto;

import constants.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultManager {

    private int reward = 0;
    public int getReward() {
        return reward;
    }

    public int getResult(List<Rank> list, Rank rank) {
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).equals(rank)){
                cnt++;
                reward += rank.getReward();
            }
            
        }
        return cnt;
    }

}

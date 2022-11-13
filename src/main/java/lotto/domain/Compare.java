package lotto.domain;

import java.util.List;

public class Compare {
    public int correctCount(List<Integer> Lotto, List<Integer> player){
        int result = 0;
        for (int i = 0; i < Lotto.size(); i++) {
            int playerNumber = player.get(i);
            if(Lotto.contains(playerNumber)){
                result++;
            }
        }
        return result;
    }

    public int bonusNumber(List<Integer> Lotto, int bonusNumber){
        int result = 0;
        if(Lotto.contains(bonusNumber)){
            result++;
        }
        return result;
    }
}

package lotto.view;

import java.util.List;

public class Rank {
    public String getWinningNumber(){
        return Message.CHOOSE_WINNING_NUMBERS.toString();
    }
    public String getBonusNumber(){
        return Message.CHOOSE_BONUS_NUMBER.toString();
    }

    public String statistics(List<Integer> ranking){
        StringBuilder msg = new StringBuilder();
        for (int i = ranking.size()-1; i>0 ; i--){
            msg.append(RankingMsg.rank(i,ranking.get(i)));
            msg.append("\n");
        }
        return msg.toString();
    }
}

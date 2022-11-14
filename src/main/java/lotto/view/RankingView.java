package lotto.view;

import lotto.domain.rank.Rank;
import lotto.domain.rank.RankInfo;

public class RankingView {
    public String getWinningNumber(){
        return Message.CHOOSE_WINNING_NUMBERS.toString();
    }
    public String getBonusNumber(){
        return Message.CHOOSE_BONUS_NUMBER.toString();
    }

    public String statistics(Rank rank) {
        StringBuilder msg = new StringBuilder();

        for(RankInfo rankInfo : rank.getRank().keySet()){
            if (rankInfo == RankInfo.OTHERS) continue;

            msg.append(rankInfo.getMsg());
            msg.append(rankInfo.getPriceMsg());
            msg.append(" - ");
            msg.append(rank.getRank().get(rankInfo));
            msg.append("개\n");
        }

        return msg.toString();
    }
}

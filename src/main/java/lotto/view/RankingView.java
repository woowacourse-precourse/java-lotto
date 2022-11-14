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

    public String statistics(Rank rank, double profit) {
        StringBuilder msg = new StringBuilder("당첨 통계\n---\n");

        for(RankInfo rankInfo : rank.getRank().keySet()){
            if (rankInfo == RankInfo.OTHERS) continue;

            msg.append(rankInfo.getMsg());
            msg.append(rankInfo.getPriceMsg());
            msg.append(" - "+rank.getRank().get(rankInfo)+"개\n");
        }
        msg.append("총 수익률은 ");
        msg.append(String.format("%.1f", profit));
        msg.append("%입니다.");

        return msg.toString();
    }
}

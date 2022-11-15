package lotto.view;

import lotto.domain.rank.Rank;
import lotto.domain.rank.RankInfo;

import java.text.DecimalFormat;

public class RankingView extends View{

    public RankingView(Rank rank, double profit) {
        initPage(statistics(rank, profit));
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
        msg.append(showProfit(profit));
        msg.append("%입니다.");

        return msg.toString();
    }

    public String showProfit(double profit){
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        return formatter.format(profit);
    }
}

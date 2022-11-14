package lotto.view.output;

import lotto.domain.RankingType;

import java.util.Map;

import static lotto.util.Constants.*;

public class ResultStatics {

    public String getString(Map<RankingType, Integer> countByRankingType){
        StringBuilder sb = new StringBuilder();
        for (RankingType rankingType : RankingType.values()) {
            if(rankingType != RankingType.DROP_OUT){
                sb.append(getConditionString(rankingType.getCondition()));
                sb.append(getBonusConditionString(rankingType.isNeedBonus()));
                sb.append(getPrizeMoney(rankingType.getPrizeMoney()));
                sb.append(getCountString(countByRankingType.get(rankingType)));
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }

    private String getConditionString(int condition){
        return String.format(CONDITION_MATCHING_INFORMATION_GUIDE, condition);
    }

    private String getBonusConditionString(boolean isNeedBonus){
        if(isNeedBonus){
            return BONUS_BALL_MATCHING_INFORMATION_GUIDE;
        }
        return BONUS_BALL_MISMATCHING_INFORMATION_GUIDE;
    }

    private String getPrizeMoney(int prizeMoney){
        return String.format(PRIZE_MONEY_INFORMATION_GUIDE,prizeMoney);
    }

    private String getCountString(int count){
        return String.format(COUNT_INFORMATION_GUIDE, count);
    }


}

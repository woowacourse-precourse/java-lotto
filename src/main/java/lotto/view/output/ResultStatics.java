package lotto.view.output;

import lotto.domain.RankingType;

import java.util.Map;

public class ResultStatics {

    public String getString(Map<RankingType, Integer> countByRankingType){
        StringBuilder sb = new StringBuilder();
        for (RankingType rankingType : RankingType.values()) {
            sb.append(getRankingString(rankingType.getKorean()));
            sb.append(getConditionString(rankingType.getCondition()));
            sb.append(getBonusConditionString(rankingType.isNeedBonus()));
            sb.append(getPrizeMoney(rankingType.getPrizeMoney()));
            sb.append(getCountString(countByRankingType.get(rankingType)));
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private String getRankingString(String ranking){
        return String.format("%s: ",ranking);
    }

    private String getConditionString(int condition){
        return String.format("%d개 일치", condition);
    }

    private String getBonusConditionString(boolean isNeedBonus){
        if(isNeedBonus){
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String getPrizeMoney(int prizeMoney){
        return String.format(" (%,d원)",prizeMoney);
    }

    private String getCountString(int count){
        return String.format(" - %d개", count);
    }


}

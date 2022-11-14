package lotto.view.output;

import lotto.domain.Lottos;
import lotto.domain.RankingType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Guide {

    public void printInputPriceGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printInputWinningLottoGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoGroup(Lottos lottoGroup){
        System.out.println(lottoGroup.getLottosString());
    }

    public void printResultGuide(){
        System.out.println("당첨 통계\n---");
    }

    public void printResult(Map<RankingType, Integer> countByRankingType){
        System.out.println(getResult(countByRankingType));
    }

    public String getResult(Map<RankingType, Integer> countByRankingType){
        StringBuilder sb = new StringBuilder();
        List<RankingType> rankingTypesKeys = Arrays.asList(RankingType.FIRST
                , RankingType.SECOND
                , RankingType.THIRD
                , RankingType.FOURTH
                , RankingType.FIFTH);
        for (RankingType rankingTypesKey : rankingTypesKeys) {
            sb.append(getConditionString(rankingTypesKey.getCondition()));
            sb.append(getBonusConditionString(rankingTypesKey.isNeedBonus()));
            sb.append(getPrizeMoney(rankingTypesKey.getPrizeMoney()));
            sb.append(getCountString(countByRankingType.get(rankingTypesKey)));
            sb.append("\n");
        }
        return sb.toString().trim();
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

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률 : %.2f%%\n",profitRate);
    }
}

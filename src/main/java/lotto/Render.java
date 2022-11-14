package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Render {
    private final static DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private final static String stringFormat = "%d개 일치 (%s원) - %d개\n";
    private final static String stringFormatBonus= "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final static String earningFormat = "총 수익률은 %.1f";
    public static void purchaseLottoResultPrint(List<Lotto> lotto){
        StringBuffer response = new StringBuffer();
        for(int i = 0;i<lotto.size();i++) {
            response.append(lotto.get(i) + "\n");
        }
        System.out.println(response);
    }
    public static void StatsResultPrint(Map<StatsType,Integer> lottoStats, Double earning){
        StringBuffer response = new StringBuffer();
        response.append("당첨 통계\n---\n");
        for(var type : lottoStats.keySet()){
            int count = type.getScore() / 10;
            int bonus = type.getScore() % 10;
            int matchCount = lottoStats.get(type);
            String moneyFormat = decimalFormat.format(type.getMoney());
            StatsFormat(response,count,bonus,matchCount,moneyFormat);
        }
        response.append(String.format(earningFormat,earning) + "%입니다.");
        System.out.println(response);
    }
    private static void StatsFormat(StringBuffer response, Integer count,  Integer bonus,Integer matchCount,String moneyFormat){
        if(bonus > 0){
            response.append(String.format(stringFormatBonus,count,moneyFormat,matchCount));
            return;
        }
        response.append(String.format(stringFormat,count,moneyFormat,matchCount));
    }

}

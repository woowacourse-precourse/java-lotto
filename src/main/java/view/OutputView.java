package View;

import domain.LottoRank;
import domain.Lotto;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printAmount(Integer amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList){
            Collections.sort(lotto.numbers);
            System.out.println((lotto.numbers));
        }

    }

    public void printTotalResult(double totalReward,int amount){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoRank.MATCH_THREE.getMatch() + " (5,000원) - " + LottoRank.MATCH_THREE.count + "개");
        System.out.println(LottoRank.MATCH_FOUR.getMatch() + " (50,000원) - " + LottoRank.MATCH_FOUR.count + "개");
        System.out.println(LottoRank.MATCH_FIVE.getMatch() + " (1,500,000원) - " + LottoRank.MATCH_FIVE.count + "개");
        System.out.println(LottoRank.MATCH_FIVE_AND_BONUS.getMatch() + " (30,000,000원) - " + LottoRank.MATCH_FIVE_AND_BONUS.count + "개");
        System.out.println(LottoRank.MATCH_SIX.getMatch() + " (2,000,000,000원) - " + LottoRank.MATCH_SIX.count + "개");
        System.out.println("총 수익률은 " + String.format("%.1f",totalReward/amount/10)+"%입니다.");
        //정리 요망

    }

}

package lotto.View;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public void showPurchasedLotto(int purchasedCount, List<List<Integer>> purchasedLottoNumber){
        System.out.print(purchasedCount + "개를 구매했습니다.");
        for(List<Integer> lottoNumbers : purchasedLottoNumber){
            System.out.println(lottoNumbers.toString());
        }
    }

    public void showLottoPrize(List<Integer> prize, List<Integer> winCount){
        final int FIRSTRANK = 4, SECONDRANK = 3, THIRDRANK = 2, FOURTHRANK = 1, FIFTHRANK = 0;
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + df.format(prize.get(FIFTHRANK)) + "원) - " + winCount.get(FIFTHRANK) + "개");
        System.out.println("4개 일치 (" + df.format(prize.get(FOURTHRANK)) + "원) - " + winCount.get(FOURTHRANK) + "개");
        System.out.println("5개 일치 (" + df.format(prize.get(THIRDRANK)) + "원) - " + winCount.get(THIRDRANK) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(prize.get(SECONDRANK)) + "원) - " + winCount.get(SECONDRANK) + "개");
        System.out.println("6개 일치 (" + df.format(prize.get(FIRSTRANK)) + "원) - " + winCount.get(FIRSTRANK) + "개");
    }

    public void showYield(double yield){
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
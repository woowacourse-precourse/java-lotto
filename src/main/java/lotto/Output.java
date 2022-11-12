package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {

    // 발행한 로또 수량 및 번호를 출력하는 기능
    public static void printPurchasedLotto(int purchaseAmount, List<List<Integer>> lotto) {
        System.out.println(purchaseAmount/1000 + "개를 구매했습니다.");
        for (List<Integer> lott : lotto) {
            System.out.println(lott.toString());
        }
    }

    // 당첨 내역을 출력하는 기능
    public static void printLottoWinningDetails(long purchaseAmount, Map<LottoMatch, Long> winningDetails) {
        long winningAmount = 0L;
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoMatch, Long> entry : winningDetails.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + df.format(entry.getKey().getValue()) + "원 ) - " + entry.getValue() + "개");
            winningAmount += entry.getKey().getValue() * entry.getValue();
        }
        System.out.println("총 수익률은 " + Calculate.getProfitRate(purchaseAmount, winningAmount) + "%입니다.");
    }

}




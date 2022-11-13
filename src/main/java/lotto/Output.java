package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    // 발행한 로또 수량 및 번호를 출력하는 기능
    public static void printPurchasedLotto(long purchaseAmount, List<Lotto> lottos) {
        System.out.println(purchaseAmount/1000 + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    // 당첨 내역을 출력하는 기능
    public static void printLottoWinningDetails(long purchaseAmount, Map<LottoMatch, Long> winningDetails) {
        long winningAmount = 0L;
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoMatch, Long> entry : winningDetails.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + df.format(entry.getKey().getValue()) + "원 ) - " + entry.getValue() + "개");
            winningAmount += entry.getKey().getValue() * entry.getValue();
        }
        System.out.println("총 수익률은 " + Calculate.getProfitRate(purchaseAmount, winningAmount) + "%입니다.");
    }

    public static void printLotto(Lotto lotto) {
        String numbers = lotto.getNumbers().stream().
                map(Object::toString).
                collect(Collectors.joining(", "));
        System.out.println("[" + numbers + "]");
    }
}




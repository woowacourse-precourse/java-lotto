package lotto;

import java.text.DecimalFormat;
import java.util.Map;

import static lotto.WinningNumber.REPEAT_INITIAL_VALUE;

public class Output {

    public static void printPurchasesCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoPurchasesNumbers(LottoNumbers lottoNumbers) {
        for (Lotto lotto : lottoNumbers.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningTicket() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Ranking, Integer> entry : lottoResult.entrySet()) {
            Ranking ranking = entry.getKey();
            int matchCount = entry.getValue();
            connectResultBoard(ranking, matchCount, stringBuilder);
        }
        System.out.printf(stringBuilder.toString());
    }

    private static void connectResultBoard(Ranking ranking, int matchCount, StringBuilder stringBuilder) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (ranking.getNumberCount() == REPEAT_INITIAL_VALUE) {
            return;
        }
        String text = String.format("%d개 일치 ", ranking.getNumberCount());
        stringBuilder.append(text);
        if (ranking.isBonusNumber()) {
            stringBuilder.append(", 보너스 볼 일치 ");
        }
        String wordConnect = "(" + decimalFormat.format(ranking.getPrizeMoney()) + "원) - " + matchCount + "개\n";
        stringBuilder.append(wordConnect);
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

}
package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class LottoPrinter {
    public static String inputer(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }

    public static void lottosPrint(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void lottoResultPrint(Map<LottoGrade, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResults.get(LottoGrade.FIVE));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResults.get(LottoGrade.FOUR));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResults.get(LottoGrade.THREE));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResults.get(LottoGrade.TWO));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResults.get(LottoGrade.ONE));
    }

    public static void revenueResultPrint(double revenue) {
        System.out.printf("총 수익률은 %.1f%s입니다.", revenue, "%");
    }
}

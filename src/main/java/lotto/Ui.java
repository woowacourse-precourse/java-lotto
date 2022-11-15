package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Ui {
    public static void printMsgToGetInput(String situation) {
        System.out.println(situation+" 입력해주세요.");
    }

    public static void printLottoNumbers(int amount, List<Lotto> issuedLottos) {
        System.out.println(amount + "개를 구매했습니다.");
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(String ratio, Map<Result, Integer> winningData) {
        System.out.println("당첨 통계\n---");

        for (Result result : Result.values()) {
            System.out.println(getStatisticsFormat(result, winningData.get(result)));
        }
        System.out.print("총 수익률은 " + ratio + "%입니다.");
    }

    private static String getStatisticsFormat(Result result, int numOfResult) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String prize = decFormat.format(result.getPrize());
        int standard = result.getStandard();

        if (result == Result.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", standard, prize, numOfResult);
        }
        return String.format("%d개 일치 (%s원) - %d개", standard, prize, numOfResult);
    }
}

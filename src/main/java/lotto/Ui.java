package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;
import static lotto.Result.*;

public class Ui {
    public static void printMsgToGetPrice() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static void printLottoNumbers(int amount, List<Lotto> issuedLottos) {
        System.out.println(amount + "개를 구매했습니다.");
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printMsgToGetWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printMsgToGetBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStatistics(String ratio, Map<Result, Integer> winningData) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Result[] results = values();
        for (int idx = results.length - 1; idx >= 0; idx--) {
            Result result = results[idx];
            System.out.println(getStatisticsFormat(result, winningData.get(result)));
        }

        System.out.print("총 수익률은 " + ratio +"%입니다.");
    }

    private static final String getStatisticsFormat(Result result, int numOfResult) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String prize = decFormat.format(result.getPrize());
        String standard = result.getStandard();

        return String.format("%s (%s원) - %d개", standard, prize, numOfResult);
    }


}

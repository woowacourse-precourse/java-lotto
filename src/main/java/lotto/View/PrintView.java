package lotto.View;

import lotto.Model.Rank;

import java.text.DecimalFormat;

import java.util.List;
import java.util.Map;

public class PrintView {

    public static void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoSheetCountMessage(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> number) {
        System.out.println(number);
    }

    public static void printWinningNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResultMessage(Map<Rank, Integer> lottoResult) {
        String str = "\n당첨 통계\n" +
                "---";
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.LOSING_TICKET))
                continue;
            if (rank.equals(Rank.BONUS)) {
                str += String.format("\n%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                        rank.getCount(),
                        getPrizeMoney(rank),
                        getWinningCount(lottoResult.get(rank)));
                continue;
            }

            str += String.format("\n%d개 일치 (%s원) - %d개",
                    rank.getCount(),
                    getPrizeMoney(rank),
                    getWinningCount(lottoResult.get(rank)));
        }
        System.out.println(str);
    }

    public static void printYieldMessage(double yield) {
        String str = "총 수익률은 " + yield + "%입니다.";
        System.out.println(str);
    }

    public static String getPrizeMoney(Rank rank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(rank.getPrizeMoney());
    }

    public static Integer getWinningCount(Integer count) {
        if (count == null) {
            return 0;
        }
        return count;
    }
}

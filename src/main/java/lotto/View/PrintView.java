package lotto.View;

import lotto.Model.Rank;

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
        String str = String.format("\n당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n",
                lottoResult.get(Rank.THREE),
                lottoResult.get(Rank.FOUR),
                lottoResult.get(Rank.FIVE),
                lottoResult.get(Rank.BONUS),
                lottoResult.get(Rank.SIX));
        System.out.println(str);
    }

    public static void printYieldMessage(int yield) {
        String str = String.format("총 수익률은 %d%%입니다.", yield);
        System.out.println(str);
    }

}

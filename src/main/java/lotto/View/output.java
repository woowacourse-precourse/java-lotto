package lotto.View;

import java.util.List;

public class output {
    final static String NoticeInputMoney = "구입금액을 입력해 주세요.";
    final static String NoticeBuyLotto = "개를 구매했습니다.";
    final static String NoticeInputWin = "당첨 번호를 입력해 주세요.";
    final static String NoticeInputBonus = "보너스 번호를 입력해 주세요.";
    final static String NoticeStatistics = "당첨 통계";
    final static String Notice5thWin = "3개 일치 (5,000원) - ";
    final static String Notice4thWin = "4개 일치 (50,000원) - ";
    final static String Notice3rdWin = "5개 일치 (1,500,000원) - ";
    final static String Notice2ndWin = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    final static String Notice1stWin = "6개 일치 (2,000,000,000원) - ";

    public static void printAmount(int amountLotto) {
        System.out.println(amountLotto + NoticeBuyLotto);
    }

    public static void printAmountLotto(List<List<Integer>> groupNumbers) {
        for (List<Integer> groupNumber : groupNumbers) {
            System.out.println(groupNumber);
        }
    }

    public static void printInputMoney() {
        System.out.println(NoticeInputMoney);
    }

    public static void printInputWin() {
        System.out.println(NoticeInputWin);
    }

    public static void printInputBonus() {
        System.out.println(NoticeInputBonus);
    }

    public static void printStatistics() {
        System.out.println(NoticeStatistics);
        System.out.println("---");
    }

    public static void printIncomeRate(double incomeRate) {
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }

    public static void printWinResult(List<Integer> winResult) {
        System.out.println(Notice5thWin + winResult.get(0) + "개");
        System.out.println(Notice4thWin + winResult.get(1) + "개");
        System.out.println(Notice3rdWin + winResult.get(2) + "개");
        System.out.println(Notice2ndWin + winResult.get(3) + "개");
        System.out.println(Notice1stWin + winResult.get(4) + "개");
    }

}

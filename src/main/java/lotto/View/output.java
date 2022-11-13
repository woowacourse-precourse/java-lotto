package lotto.View;

import java.util.List;

public class output {
    final static String NoticeInputMoney = "구입금액을 입력해 주세요.";
    final static String NoticeBuyLotto = "개를 구매했습니다.";
    final static String NoticeInputWin = "당첨 번호를 입력해 주세요.";
    final static String NoticeInputBonus = "보너스 번호를 입력해 주세요.";
    final static String NoticeStatistics = "당첨 통계";

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
}

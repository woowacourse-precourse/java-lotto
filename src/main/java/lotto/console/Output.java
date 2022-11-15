package lotto.console;

import lotto.domain.Statistic;

import java.util.List;


public class Output {

    public static void printLotto(List<Integer> lst) {
        System.out.println(String.format("%s", lst.toString()));
    }

    public static void printStatistics() {
        System.out.println("당첨 통계\n---");
    }

    public static void printGrading(int idx, int correctCnt) {
        System.out.println(String.format(Statistic.getMsg(idx), correctCnt));
    }

    public static void printRevenueRate(float rate) {
        System.out.println(String.format("총 수익률은 %.1f", rate) + "%입니다.");
    }

    public static void printBuyLotto(int cnt) {
        System.out.println(String.format("%d개를 구매했습니다.", cnt));
    }

    public static void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printInputCost() {
        System.out.println("구입금액을 입력해 주세요.");
    }

}
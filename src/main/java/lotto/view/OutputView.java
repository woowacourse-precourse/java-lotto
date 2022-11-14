package lotto.view;

import java.util.List;
import lotto.domain.Rank;

public class OutputView {

    public static final String ERROR_STATEMENT = "[ERROR] ";
    public static final String MESSAGE_FIRST = "6개 일치 (2,000,000,000원) - ";
    public static final String MESSAGE_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String MESSAGE_THIRD = "5개 일치 (1,500,000원) - ";
    public static final String MESSAGE_FOURTH = "4개 일치 (50,000원) - ";
    public static final String MESSAGE_FIFTH = "3개 일치 (5,000원) - ";

    public static void printErrorMessage(Exception error) {
        System.out.println(ERROR_STATEMENT + error.getMessage());
    }

    public static void printCashInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTicketNumber(int ticketNumber) {
        System.out.println(ticketNumber + "개를 구매했습니다.");
    }

    public static void printWinningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPlayerNumbers(List<List<Integer>> allPlayerNumbers) {
        for (List<Integer> playerNumbers : allPlayerNumbers) {
            System.out.println(playerNumbers);
        }
    }

    public static void printStatistics(Rank ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : ranks.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            System.out.print(rank.getPrintMessage());
            System.out.println(rank.getCount() + "개");
        }
    }

    public static void printYield(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

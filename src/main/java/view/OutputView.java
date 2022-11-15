package view;

import constant.Statistics;
import domain.LottoGame;
import java.util.List;

public class OutputView {

    private static final String BUYMONEY = "구입 금액을 입력해주세요.";
    private static final String INPUT_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해주세요.";
    private static final String START_STATISTICS = "당첨 통계\n---";


    public static void printButMoney() {
        System.out.println(BUYMONEY);
    }

    public static void printInputLotto() {
        System.out.println(INPUT_LOTTO);
    }

    public static void printInputBonus() {
        System.out.println(INPUT_BONUS);

    }


    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLottoTickets(int count, List<List<Integer>> printTickets) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> lottoTicket : printTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printStatistics() {
        List<Integer> rankedBox = LottoGame.getRankedBox();
        float yield = LottoGame.getYield();
        System.out.println(START_STATISTICS);
        System.out.println(Statistics.LAST_RANKED.getStatistics() + rankedBox.get(0) + "개");
        System.out.println(Statistics.FOURTH_RANKED.getStatistics() + rankedBox.get(1) + "개");
        System.out.println(Statistics.THIRD_RANKED.getStatistics() + rankedBox.get(2) + "개");
        System.out.println(Statistics.SECOND_RANKED.getStatistics() + rankedBox.get(4) + "개");
        System.out.println(Statistics.FIRST_RANKED.getStatistics() + rankedBox.get(3) + "개");
        System.out.println(getprintYieldStatistics(yield));
    }

    private static String getprintYieldStatistics(float yield) {
        String Yield = "총 수익률은 " + String.format("%.1f", yield) + "%입니다.";
        return Yield;
    }
}

package lotto.view;

import lotto.Lottos;
import lotto.Rank;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_PAY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String GAME_STATISTICS = "당첨통계\n___";

    public static void printLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            System.out.println(lottos.getLottos().get(i).toString());
        }
    }

    public static void printStatistics(Map<Rank, Integer> statistics) {

        for (Rank rank : statistics.keySet()) {
            printResult(rank, statistics);
        }
    }

    private static void printResult(Rank rank, Map<Rank, Integer> statistics) {
        if (validateMatchCountIs5(rank)) {
            System.out.print(String.format("%d개 일치, 보너스 볼 일치 (%,d원)", rank.getMatchCount(), rank.getReward()));
            System.out.println(" - " + statistics.get(rank) + '개');
        } else if (validateMatchCountOver3(rank)) {
            System.out.print(String.format("%d개 일치 (%,d원)", rank.getMatchCount(), rank.getReward()));
            System.out.println(" - " + statistics.get(rank) + '개');
        }
    }

    private static boolean validateMatchCountOver3(Rank rank) {
        return rank.getMatchCount() >= 3;
    }

    private static boolean validateMatchCountIs5(Rank rank) {
        return rank.getMatchCount() == 5 && rank.isBonusMatch();
    }

    public static void printPayMessage() {
        System.out.println(LOTTO_PAY_MESSAGE);
    }

    public static void printWinningLottoNumberMessage() {
        System.out.println(WINNING_LOTTO_NUMBER_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printGameStatistics() {
        System.out.println(GAME_STATISTICS);
    }

    public static void printEarningRate(String calculateEarningRate) {
        System.out.printf("총 수익률은 %s" + "%%입니다.", calculateEarningRate);
    }
}

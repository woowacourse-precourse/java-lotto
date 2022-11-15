package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final DecimalFormat MONEY_DECIMAL = new DecimalFormat("###,###");

    private OutputView() {
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getIntegerNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankCount(lottoResult);
        printYield(lottoResult.calculateYield());
    }

    private static void printRankCount(LottoResult lottoResult) {
        Arrays.stream(Rank.values).filter(value -> value != Rank.NONE).forEach(value -> {
            printRankMessage(lottoResult, value);
            System.out.println();
        });
    }

    private static void printRankMessage(LottoResult lottoResult, Rank rank) {
        if (rank == Rank.SECOND) {
            printSecondRank(lottoResult, rank);
            return;
        }
        printDefaultRank(lottoResult, rank);
    }

    private static void printSecondRank(LottoResult lottoResult, Rank rank) {
        System.out.printf(
                "%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                rank.getMatchCount(),
                MONEY_DECIMAL.format(rank.getReward()),
                lottoResult.countRank(rank)
        );
    }

    private static void printDefaultRank(LottoResult lottoResult, Rank rank) {
        System.out.printf(
                "%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                MONEY_DECIMAL.format(rank.getReward()),
                lottoResult.countRank(rank)
        );
    }

    private static void printYield(Double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield * 100);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}

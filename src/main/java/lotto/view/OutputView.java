package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Winner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {
    private final String YOU_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private final String PRIZE_STATISTICS_MESSAGE = "당첨통계\n---";
    private final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private final String RANK_MESSAGE = "%d개 일치 (%s원) - %d개";
    private final String SECOND_RANK_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void printPurchaseCount(int count) {
        try {
            String formatted = String.format(YOU_PURCHASED_MESSAGE, count);
            bw.write(formatted);
            bw.newLine();
        } catch (IOException e) {

        }
    }

    void printTotalProfitPercent(float profit) {
        try {
            String formatted = String.format(PROFIT_MESSAGE, profit);
            bw.write(formatted);
        } catch (IOException e) {

        }

    }

    void printStatisticsByRank(Winner winner, int winCount) {
        try {
            String raw = RANK_MESSAGE;
            if (winner.equals(Winner.SECOND)) {
                raw = SECOND_RANK_MESSAGE;
            }
            String formatted = String.format(raw, winner.getCorrectnessCount(), winner.getPrizeMoneyToString(), winCount);
            bw.write(formatted);
            bw.newLine();
        } catch (IOException e) {

        }
    }

    void printStatisticStart() {
        try {
            bw.write(PRIZE_STATISTICS_MESSAGE);
            bw.newLine();
        } catch (IOException e) {

        }
    }

    void printAllLotto(List<Lotto> lottoList) {
        try {
            for (Lotto lotto : lottoList) {
                bw.write(lotto.toString());
                bw.newLine();
            }
            bw.newLine();
        } catch (IOException e) {

        }
    }

    private void printNewLine() {
        try {
            bw.newLine();
        } catch (IOException e) {

        }
    }

    void flush() {
        try {
            bw.flush();
        } catch (IOException e) {

        }
    }

}

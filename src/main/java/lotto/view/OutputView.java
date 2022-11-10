package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Winner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {
    private final String YOU_PURCHASED_MESSAGE = "개를 구매했습니다.";
    private final String PRIZE_STATISTICS_MESSAGE = "당첨통계\n---";
    private final String WINNER_MESSAGE = "개 일치";
    private final String BONUSBALL_MESSAGE = "보너스 볼 일치";
    private final String OUTPUT_PRIZE_MESSAGE = WINNER_MESSAGE + "()" + BONUSBALL_MESSAGE + " - " + " 개";
    private final String PROFIT_MESSAGE = "총 수익률은 입니다.";

    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printPurchaseCount(int count) {
        try {
            bw.write(String.valueOf(count));
            bw.write(YOU_PURCHASED_MESSAGE);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {

        }
    }

    void printStatisticsByRank(Winner winner, int winCount) {
        try {
            bw.write(winner.getCorrectnessCount());
            bw.write(WINNER_MESSAGE);
            bw.write(" (");
            bw.write(winner.getPrizeMoney());
            bw.write("원) - ");
            bw.write(winCount);
            bw.write("개");
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

    public void printAllLotto(List<Lotto> lottoList) {
        try {
            for (Lotto lotto : lottoList) {
                bw.write(lotto.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {

        }
    }

    private void printNewLine() {
        try {
            bw.newLine();
        } catch (IOException e) {

        }
    }

}

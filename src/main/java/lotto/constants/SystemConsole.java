package lotto.constants;

import java.util.List;

public class SystemConsole {

    public void GAME_START_MESSAGE() {
        System.out.println(SystemMessage.PURCHASE_AMOUNT_MESSAGE);
    }

    public void COMPLETED_PURCHASE(int lottos) {
        System.out.println();
        System.out.println(lottos + SystemMessage.BUY_LOTTO_MESSAGE);
    }

    public void winningNumbers() {
        System.out.println();
        System.out.println(SystemMessage.PRIZE_AMOUNT_MESSAGE);
    }

    public void bonusNumber() {
        System.out.println();
        System.out.println(SystemMessage.BONUS_NUMBER_MESSAGE);
    }

    public void winningStatistics() {
        System.out.println();
        System.out.println(SystemMessage.WINNING_STATISTICS_MESSAGE);
        System.out.println(SystemMessage.LINE_MESSAGE);
    }

    public void winningRanking(int c, int m, int p) {
        System.out.println(
                m + "개 일치 (" + NumberFormat.getNumberInstance().format(p) + "원) - " + c + "개");
    }

    public void winningRankingSecond(int c, int m, int p) {
        System.out.println(
                m + "개 일치, 보너스 볼 일치 (" + NumberFormat.getNumberInstance().format(p) + "원) - " + c
                        + "개");
    }

    public void grossYields(double revenue) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", revenue));
    }

}
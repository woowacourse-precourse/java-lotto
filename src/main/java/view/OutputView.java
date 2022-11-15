package view;

import domain.LottoRank;
import domain.Lotto;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String SEPARATION = "---";

    public void printAmount(Integer amount) {
        System.out.println(amount + LOTTO_AMOUNT);
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println((lotto.numbers));
        }

    }

    public void printTotalResult() {
        System.out.println(WINNING_STATS);
        System.out.println(SEPARATION);
        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf(lottoRank.getInfo() + " (%s원) - "
                    + lottoRank.count + "개\n", NumberFormat.getInstance().format(lottoRank.getReward()));
        }

    }

    public void printReturnRate(double totalReward, int amount) {
        System.out.println("총 수익률은 " + String.format("%.1f", totalReward / amount / 10) + "%입니다.");
    }

}

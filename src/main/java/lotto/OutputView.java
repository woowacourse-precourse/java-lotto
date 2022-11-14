package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printBuyLottoTicket(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.\n", exchangeTicket(purchaseAmount));
    }

    public void printBuyLotto(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println("");
    }
    public void printStatistics(Map<Rank, Integer> totalResult){

        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            System.out.printf(rank.getText(), totalResult.get(rank));
            System.out.println("");
        }
    }

    public void printPercentage(double percentage) {
        System.out.printf("총 수익률은 %.1f%%입니다.", percentage);
    }

    private int exchangeTicket(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

}

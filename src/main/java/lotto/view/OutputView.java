package lotto.view;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String SPACE = " ";

    public void printBuyLottoTicket(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.\n", exchangeTicket(purchaseAmount));
    }

    public void printBuyLotto(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println("");
    }

    public void printStatistics(Map<Rank, Integer> totalResult) {

        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            System.out.printf(rank.getText(), totalResult.get(rank));
            System.out.println("");
        }
    }

    public void printException(Exception e) {
        System.out.println(ERROR_MESSAGE + SPACE + e.getMessage());
    }

    public void printPercentage(double percentage) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        System.out.println("총 수익률은 " + formatter.format(percentage) + "%입니다.");
    }

    private int exchangeTicket(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

}

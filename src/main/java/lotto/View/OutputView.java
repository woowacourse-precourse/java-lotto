package lotto.View;

import lotto.Domain.LottoPublisher;
import lotto.Domain.MatchWinning;
import lotto.Domain.ProfitCalculator;
import lotto.Domain.WinningPrice;

import java.util.List;

public class OutputView {

    LottoPublisher lottoPublisher;
    WinningPrice winningPrice;
    MatchWinning matchWinning;
    ProfitCalculator profitCalculator;

    public void printTheNumberOfLotto(int theNumberOfLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", theNumberOfLotto));
    }

    public void printLottoNumber(List<List<Integer>> userInputLottoNumberList) {
        for (List<Integer> column : userInputLottoNumberList) {
            System.out.println(column);
        }
    }

    public void printResultOfLotto() {
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println(WinningPrice.FIFTH.getWinningMessage() + matchWinning.getFifthPrice() + "개");
        System.out.println(WinningPrice.FORTH.getWinningMessage() + matchWinning.getForthPrice() + "개");
        System.out.println(WinningPrice.THIRD.getWinningMessage() + matchWinning.getThirdPrice() + "개");
        System.out.println(WinningPrice.SECOND.getWinningMessage() + matchWinning.getSecondPrice() + "개");
        System.out.println(WinningPrice.FIRST.getWinningMessage() + matchWinning.getFirstPrice() + "개");
    }

    public void printProfit() {
        System.out.println("수익률은 " + profitCalculator.calculateProfit() + "입니다");
    }

    public void printEmptyLine() {
        System.out.println();
    }
}

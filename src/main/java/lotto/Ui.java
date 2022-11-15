package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Ui {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String returnInputValue(String message) {
        System.out.println(message);
        String input = Console.readLine();
        return input;
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> tempLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(tempLotto);
            System.out.println(tempLotto);
        }
    }

    public void printWinningStatistics(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", winningResult.getCount(LottoRating.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", winningResult.getCount(LottoRating.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", winningResult.getCount(LottoRating.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winningResult.getCount(LottoRating.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", winningResult.getCount(LottoRating.FIRST));
    }

    public void printTotalProfit(WinningResult winningResult, String purchaseAmount) {
        System.out.printf("총 수익률은 %.1f입니다.", winningResult.createProfit(purchaseAmount));
    }
}

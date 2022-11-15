package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;

import java.math.BigDecimal;
import java.util.List;

public class ConsoleOutput {

    public void printLottoList(int amount, LottoList lottoList) {
        LottoAmount(amount);
        System.out.println(lottoList.toString());
    }

    public void LottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printStatistics(String statistics) {
        System.out.println("당첨 통계\n---");
        printSameCountPhrase(statistics);
    }
    public void printSameCountPhrase(String rankStatistics) {
        System.out.println(rankStatistics);
    }
    public void printProfitRatio(BigDecimal ratio) {
        System.out.println("총 수익률은 " + ratio + "입니다.");
    }
}

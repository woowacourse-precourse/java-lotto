package lotto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;

public class Ouput {
    public void notifyPurchasedLottoTable(List<Lotto> lottoTable) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTable.size());
        for (int i = 0; i < lottoTable.size(); i++) {
            System.out.println(lottoTable.get(i).getNumbers());
        }
    }

    public void notifyHowMuchInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void notifyWinningLottoNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void notifyBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void notifyRateOfReturn(float rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", sumOfResult.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", sumOfResult.get(1));
        System.out.printf("5개 일치 (1,500,000원) - 0개\n", sumOfResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n", sumOfResult.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - 0개\n", sumOfResult.get(4));

    }
}

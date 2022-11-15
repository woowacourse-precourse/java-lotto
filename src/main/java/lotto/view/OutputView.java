package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Statistic.BONUS;
import static lotto.service.LottoService.calculateProfit;

public class OutputView {
    public static void printLottoNumber(int count, List<Lotto> lottoList) {
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }

    public static void printLottoResult(int count, HashMap<Statistic, Integer> countStatistic) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        for (Statistic e : Statistic.values()) {
            if (e == BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", e.getMatchingNumber(), decFormat.format(e.getPrize()), countStatistic.get(e));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개%n", e.getMatchingNumber(), decFormat.format(e.getPrize()), countStatistic.get(e));
        }
        System.out.printf("총 수익률은 %s%%입니다.%n", calculateProfit(count, countStatistic));
    }
}

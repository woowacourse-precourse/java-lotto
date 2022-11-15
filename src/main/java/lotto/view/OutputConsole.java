package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputConsole {

    public static void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = new ArrayList<>(lottos.get(i).getNumbers());
            Collections.sort(lottoNumbers);
            String lottoNumbersMessage = lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbersMessage + "]");
        }
    }

    public static void printWinningList(Map<Rank, Integer> rankResult) {
        System.out.println("당첨통계");
        System.out.println("---");
        for (Rank key : rankResult.keySet()) {
            if (key == Rank.NOTHING) {
                continue;
            }
            System.out.println(key.getScoreText() + " - " + rankResult.get(key) + "개");
            ;
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}

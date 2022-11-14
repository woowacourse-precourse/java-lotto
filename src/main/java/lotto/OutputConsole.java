package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputConsole {

    public static void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers= lottos.get(i).getNumbers();
            Collections.sort(lottoNumbers);
            String lottoNumbersMessage = lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbersMessage + "]");
        }
    }

    public static void printWinningList(Map<Rank, Integer> rankResult) {
        System.out.println("당첨통계");
        System.out.println("---");
        for (Rank key: rankResult.keySet()){
            if (key == Rank.NOTHING) {
                continue;
            }
            System.out.println(key.getScoreText() + "- " + rankResult.get(key) +"개");;
        }
    }

    public static void printProfitRate(List<Lotto> lottos, int investmentMoney, List<Integer> winningNumber, int bonusNumber) {
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        double profitRate = profitRateCalculator.calculate(lottos, investmentMoney, winningNumber, bonusNumber);
        System.out.println("총 수익률은 " + profitRate+ "%입니다.");
    }
}

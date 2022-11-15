package lotto.view;

import lotto.model.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void moneyOutput(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void lottoFactoryOutput(int lottoAmout, List<List<Integer>> lottos) {
        for (int i = 0; i < lottoAmout; i++) {
            lottoOutput(lottos.get(i));
        }
    }

    public void lottoOutput(List<Integer> lotto) {
        String output = "[" + Integer.valueOf(lotto.get(0));
        for (int i = 1; i < lotto.size(); i++) {
            output += ", " + Integer.valueOf(lotto.get(i));
        }
        output += "]";

        System.out.println(output);
    }

    public void lottoResult(Map<Prize, Integer> lottoCount, double yield) {
        System.out.println("당첨 통계\n" + "---");
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> printPrize(prize, lottoCount.getOrDefault(prize, 0)));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    public void printPrize(Prize prize, int lottoCount) {
        if (prize.isBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", prize.getLottoCount(), prize.getWinningMoneyString(), lottoCount);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", prize.getLottoCount(), prize.getWinningMoneyString(), lottoCount);
    }
}

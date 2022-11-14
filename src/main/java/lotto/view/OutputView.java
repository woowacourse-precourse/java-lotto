package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.status.WinningStatus;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private final DecimalFormat decFormat = new DecimalFormat("###,###");

    public void printUserLotto(List<Lotto> userLotto) {
        System.out.println(userLotto.size() + "개를 구매했습니다.");
        for (Lotto lottoPiece : userLotto) {
            System.out.println(lottoPiece.getNumbers());
        }
    }

    public void printWinningResult(List<Integer> result) {
        for (int i = 3; i < 8; i++) {
            printEachResult(result, i);
        }
        System.out.println();
    }

    private void printEachResult(List<Integer> result, Integer i) {
        if (i == 6) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", WinningStatus.find(i).getNumberMatchCount(),
                    decFormat.format(WinningStatus.find(i).getReward()), result.get(i));
            System.out.println();
        }
        System.out.printf("%d개 일치 (%s원) - %d개", WinningStatus.find(i).getNumberMatchCount(),
                decFormat.format(WinningStatus.find(i).getReward()), result.get(i));
        System.out.println();
    }

    public static void printProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}

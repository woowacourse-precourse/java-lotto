package lotto.View;

import lotto.Domain.LottoWinningCriteria;
import lotto.Domain.LottoWinningMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printUserLotto(List<List<Integer>> userLotto) {
        System.out.println(userLotto.size() + "개를 구매했습니다.");
        for (List<Integer> lottoSheet : userLotto) {
            System.out.println(lottoSheet);
        }
    }

    public static void printUserResultLottoMessage() {
        ArrayList<Integer> userLottoCount = new ArrayList<>();
        Arrays.stream(LottoWinningCriteria.values()).forEach(m -> userLottoCount.add(m.getCount()));

        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoWinningMessage lottoWinningMessage : LottoWinningMessage.values()) {
            System.out.printf(lottoWinningMessage.getWinningMessage() + '\n', userLottoCount.remove(0));
        }
    }

    public static void printUserProfit(double profitPercent) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitPercent);
    }
}


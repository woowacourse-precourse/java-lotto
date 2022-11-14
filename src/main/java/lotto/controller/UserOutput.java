package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserOutput {
    public static void viewLotto(ManageLotto manageLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", manageLotto.getLottoNum()));
        for (Lotto newLotto: manageLotto.getMyLotto()) {
            List<Integer> tmpNumbers = new ArrayList<>(newLotto.getLottoNumbers());
            tmpNumbers.sort(Comparator.naturalOrder());
            System.out.println(tmpNumbers);
        }
        System.out.println();
    }

    public static void viewLottoResult(ManageLotto manageLotto, WinningNumber winningNumber) {
        int[] ranks  = {0,0,0,0,0,0};
        for (Lotto newLotto: manageLotto.getMyLotto()) {
            int index = LottoCalculator.rankOfThisLotto
                    (newLotto.getLottoNumbers(), winningNumber.getLottoNumbers(), winningNumber.getBonusNumber());
            ranks[index]++;
        }

        System.out.println(String.format("당첨 통계\n---\n" +
                        "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개",
                ranks[5], ranks[4], ranks[3], ranks[2], ranks[1]));

        System.out.println(String.format(
                "총 수익률은 %.1f%%입니다.", LottoCalculator.calculateYield(manageLotto.getBudget(), ranks)
        ));
    }
}

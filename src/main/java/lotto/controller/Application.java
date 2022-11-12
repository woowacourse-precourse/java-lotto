package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.controller.LottoCalculator;

import lotto.controller.ManageLotto;

public class Application {
    public static void main(String[] args) {
        ManageLotto manageLotto = new ManageLotto();
        System.out.println("구입금액을 입력해 주세요.");
        manageLotto.numberOfLotto(Console.readLine());
        System.out.println();

        System.out.println(String.format("%d개를 구매했습니다.", manageLotto.lottoNum));
        manageLotto.makeMyLotto(manageLotto.lottoNum);
        for (Lotto newLotto: manageLotto.myLotto) {
            List<Integer> tmpNumbers = new ArrayList<>(newLotto.getLottoNumbers());
            tmpNumbers.sort(Comparator.naturalOrder());
            System.out.println(tmpNumbers);
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        WinningNumber answer = new WinningNumber(Console.readLine());
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        answer.setBonusNumber(Integer.valueOf(Console.readLine()));

        int[] ranks  = {0,0,0,0,0,0};
        for (Lotto newLotto: manageLotto.myLotto) {
            int index = LottoCalculator.rankOfThisLotto
                    (newLotto.getLottoNumbers(), answer.getWinningNumber(), answer.getBonusNumber());
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
                "총 수익률은 %.1f%%입니다.", LottoCalculator.calculateYield(manageLotto.budget, ranks)
        ));
    }
}

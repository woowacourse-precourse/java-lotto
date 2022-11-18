package lotto.ui;

import lotto.Lotto;

import java.util.List;

public class UserOutput {
    public void PrintResult(List<Integer> match, int totalMoney) {
        int totalPrize = 5000 * match.get(0) + 50_000 * match.get(1) + 1_500_000 * match.get(2)
                + 30_000_000 * match.get(3) + 2_000_000_000 * match.get(4);

        float profitPercentage = (float) totalPrize / (float) totalMoney;
        profitPercentage *= 100;

        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", match.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", match.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", match.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", match.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", match.get(4));
        System.out.printf("총 수익률은 %.1f%%입니다.", profitPercentage);
    }

    public void PrintBoughtLotto(List<Lotto> myLotto) {
        System.out.printf("%d개를 구매했습니다.\n", myLotto.size());
        for (var e : myLotto) System.out.println(e.GetLottoNumber().toString());

    }
}

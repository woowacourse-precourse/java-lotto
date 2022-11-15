package lotto.view;

import lotto.Lotto;

import java.util.List;

public class View_Output {
    public void showPieces(int amount) {
        System.out.print("\n" + amount + "개를 구매했습니다.\n");
    }

    public void showLottos(List<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); ++i) {
            System.out.println(lottos.get(i).getNumbers());
        }
        System.out.println();
    }

    public void preShowPrice() {
        System.out.print("당첨 통계\n---\n");
    }
    public void showPrice(int three, int four, int five, int fiveWithBonus, int six) {
        System.out.print("3개 일치 (5,000원) - " + three + "개\n");
        System.out.print("4개 일치 (50,000원) - " + four + "개\n");
        System.out.print("5개 일치 (1,500,000원) - " + five + "개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonus + "개\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + six + "개\n");
    }

    public void showProfits(long earnings, int costs) {
        long temp = earnings * 1000 / costs;
        double profits = (double)temp / 10;
        System.out.print("총 수익률은 " + profits + "%입니다.\n");
    }
}

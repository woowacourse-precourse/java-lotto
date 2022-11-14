package lotto;

public class Print {
    public void lotto(User user) {
        System.out.printf("%d개를 구매했습니다.\n", user.getNumberOfLotto());
        for (Lotto lotto: user.getLotto()) {
            System.out.println(lotto.getLottoNum());
        }
    }

    public void winningStat(Calculator calc) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개\n5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n6개 일치 (2,000,000,000원) - %d개\n",
                calc.getCountByRank(5),
                calc.getCountByRank(4),
                calc.getCountByRank(3),
                calc.getCountByRank(2),
                calc.getCountByRank(1));
    }

    public void yield(Calculator calc) {
        System.out.printf("총 수익률은 %.1f%%입니다.", calc.getYield());
    }
}

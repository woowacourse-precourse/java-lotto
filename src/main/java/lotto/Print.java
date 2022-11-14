package lotto;

import java.text.DecimalFormat;

public class Print {
    public void lotto(User user) {
        System.out.printf("%d개를 구매했습니다.\n", user.getNumberOfLotto());
        for (Lotto lotto: user.getLotto()) {
            System.out.println(lotto.getLottoNum());
        }
    }

    public void winningStat(Calculator calc) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank: Rank.values()) {
            System.out.printf("%s (%s원) - %d개\n", rank.getCondition(),
                    decFormat.format(rank.getPrize()),
                    calc.getCountByRank(rank.getPlace()));
        }
    }

    public void yield(Calculator calc) {
        System.out.printf("총 수익률은 %.1f%%입니다.", calc.getYield());
    }
}

package lotto.ui.text;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.result.RewardEnum;

public class DynamicText {
    public static String totalQuantity(int quantity) {
        return String.format("%d개를 구매했습니다.\n", quantity);
    }

    public static String totalLotto(List<Lotto> lottoList) {
        StringBuilder text = new StringBuilder();

        for (Lotto lotto : lottoList) {
            text.append(lotto);
            text.append("\n");
        }
        return text.toString();
    }

    public static String statistics(Map<RewardEnum, Integer> statistics) {
        int earn = 0;
        int money = 0;

        for (RewardEnum rewardEnum : statistics.keySet()) {
            earn += rewardEnum.getReward() * statistics.get(rewardEnum);
            money += 1000 * statistics.get(rewardEnum);
        }

        return String.format("당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - %d개\n"
                        + "4개 일치 (50,000원) - %d개\n" + "5개 일치 (1,500,000원) - %d개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" + "6개 일치 (2,000,000,000원) - %d개\n"
                        + "총 수익률은 %.1f%%입니다.",
                statistics.get(RewardEnum.WIN_3), statistics.get(RewardEnum.WIN_4),
                statistics.get(RewardEnum.WIN_5), statistics.get(RewardEnum.WIN_5_BONUS),
                statistics.get(RewardEnum.WIN_6), 100.00 * earn / money
        );
    }
}

package lotto.Utils;

import lotto.Lotto;
import lotto.domain.WinInfo;

import java.util.*;

public class Print {
    public void askAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void purchaseCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }
    public void purchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }
    public void winningStats(LinkedHashMap<String, Integer> winningStats) {
        System.out.println("당첨 통계\n---");
        for (Map.Entry<String, Integer> entry : winningStats.entrySet()) {
            String key = entry.getKey();
            System.out.printf("%d개 일치", WinInfo.valueOf(key).getMatch());
            if (key.equals("SECOND"))
                System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%s) - %d개\n" , WinInfo.valueOf(key).getWinnings(), winningStats.get(key));
        }
    }
    public void returnRate(String returnRate) {
        System.out.printf("총 수익률은 %s%%입니다.\n", returnRate);
    }
}

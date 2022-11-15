package lotto.domain;

import lotto.Lotto;

import java.util.*;

public class WinningStats {
    private final LinkedHashMap<WinInfo, Integer> stats = new LinkedHashMap<>();
    private int purchase;
    private int total;

    public WinningStats(int purchase, List<Lotto> lottos) {
        this.purchase = purchase;

        for (WinInfo info : WinInfo.values()) {
            stats.put(info, 0);
        }

        for (Lotto lotto : lottos) {
            putStat(lotto);
        }
    }

    private void putStat(Lotto lotto) {
        WinInfo info = lotto.getWinInfo();
        int count = stats.getOrDefault(info, 0);
        stats.put(info,count + 1);
        total += info.getReward();
    }

    public void print() {
        System.out.println("당첨 통계\n---");
        for (Map.Entry<WinInfo, Integer> entry : stats.entrySet()) {
            WinInfo key = entry.getKey();
            if (key == WinInfo.NONE) {
                continue;
            }
            System.out.printf(key.getFormat(), key.getReward(), entry.getValue());
            System.out.println();
        }
        System.out.printf("\n총 수익률은 %.1f%%입니다.\n", (total / (float)purchase) * 100f);
    }
}

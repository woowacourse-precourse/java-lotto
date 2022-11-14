package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {
    private static final WinningLotto winningLotto = new WinningLotto(
        new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),7);

    @Test
    void 로또_3등_5등_당첨_통계_테스트() {
        LottoPurchase lottoPurchase = new LottoPurchase(new ArrayList<>(
            List.of(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 8, 9, 10))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10)))
            )
        ));

        lottoPurchase.compareNumberByWinning(winningLotto);
        lottoPurchase.calculateYieldPercent();

        assertEquals(lottoPurchase.getLottoStatsDTO().getRankCounts(), List.of(1, 0, 1, 0, 0));
        assertEquals(lottoPurchase.getLottoStatsDTO().getYieldPercent(), 75250.0);
    }

    @DisplayName("로또 이익률은 소수 두번째 자리에서 반올림 되어야 한다.")
    @Test
    void 로또_이익률_반올림_테스트() {
        LottoPurchase lottoPurchase = new LottoPurchase(new ArrayList<>(
            List.of(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 8, 9, 10))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 9, 10))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40)))
            )
        ));
        lottoPurchase.compareNumberByWinning(winningLotto);
        lottoPurchase.calculateYieldPercent();

        assertEquals(lottoPurchase.getLottoStatsDTO().getRankCounts(), List.of(1, 1, 0, 0, 0));
        assertEquals(lottoPurchase.getLottoStatsDTO().getYieldPercent(), 916.7);
    }

    @Test
    void 로또_이익률_0_테스트() {
        LottoPurchase lottoPurchase = new LottoPurchase(new ArrayList<>(
            List.of(
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40))),
                new Lotto(new ArrayList<>(List.of(45, 44, 43, 42, 41, 40)))
            )
        ));
        lottoPurchase.compareNumberByWinning(winningLotto);
        lottoPurchase.calculateYieldPercent();

        assertEquals(lottoPurchase.getLottoStatsDTO().getRankCounts(), List.of(0, 0, 0, 0, 0));
        assertEquals(lottoPurchase.getLottoStatsDTO().getYieldPercent(), 0);
    }
}

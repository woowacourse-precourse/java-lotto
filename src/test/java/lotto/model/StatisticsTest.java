package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StatisticsTest {
    private static final String COMPARE_STATISTICS = "3개 일치 (5,000원) - 1개\n" +
            "4개 일치 (50,000원) - 1개\n" +
            "5개 일치 (1,500,000원) - 0개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
            "6개 일치 (2,000,000,000원) - 1개";

    private final List<Lotto> lottos = new ArrayList<>();
    private final WinningLotto winningLotto = new WinningLotto(List.of(6, 5, 3, 4, 2, 1), 7);

    @BeforeEach
    void beforeEach() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottos.add(new Lotto(lottoNumbers));
        for (int i = 0; i < 4; i++) {
            lottoNumbers = lottoNumbers.stream().map((num) -> num + 1)
                    .collect(Collectors.toUnmodifiableList());
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    @DisplayName("올바른 통계 결과를 내는지 확인한다.")
    @Test
    void testToString() {
        RankCount rankCount = new RankCount(lottos, winningLotto);
        Statistics statistics = new Statistics(rankCount);

        Assertions.assertThat(statistics.toString()).isEqualTo(COMPARE_STATISTICS);
    }

    @DisplayName("컴퓨터가 올바른 ")
    @Test
    void computeRightTotalPrice() {
        RankCount rankCount = new RankCount(lottos, winningLotto);
        Statistics statistics = new Statistics(rankCount);

        long resultTotalPrice = statistics.computeTotalPrice();
        long expectedTotalPrice = 2030055000L;

        Assertions.assertThat(resultTotalPrice).isEqualTo(expectedTotalPrice);
    }
}
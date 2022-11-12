package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StatisticsTest {
    private static final String COMPARE_STATISTICS = "3개 일치 (5,000원) - 1개\n" +
            "4개 일치 (50,000원) - 1개\n" +
            "5개 일치 (1,500,000원) - 0개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
            "6개 일치 (2,000,000,000원) - 1개\n";

    private final List<Lotto> lottos = new ArrayList<>();
    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    @BeforeEach
    void beforeAll() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottos.add(new Lotto(lottoNumbers));
        for (int i = 0; i < 4; i++) {
            lottoNumbers = lottoNumbers.stream().map((num) -> num + 1)
                    .collect(Collectors.toUnmodifiableList());
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    @DisplayName("로또들 중 당첨 로또의 개수를 세는 기능이 동작한다.")
    @Test
    void countFirstRank() {
        Statistics statistics = new Statistics(lottos, winningLotto);

        Map map = statistics.countRank();
        Assertions.assertThat(map.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또들 중 당첨 로또의 개수를 세는 기능이 동작한다.")
    @Test
    void countSecondRank() {
        Statistics statistics = new Statistics(lottos, winningLotto);

        Map map = statistics.countRank();
        Assertions.assertThat(map.get(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("로또들 중 당첨 로또의 개수를 세는 기능이 동작한다.")
    @Test
    void countThirdRank() {
        Statistics statistics = new Statistics(lottos, winningLotto);

        Map map = statistics.countRank();
        Assertions.assertThat(map.get(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("로또들 중 당첨 로또의 개수를 세는 기능이 동작한다.")
    @Test
    void countNothingRank() {
        Statistics statistics = new Statistics(lottos, winningLotto);

        Map map = statistics.countRank();
        Assertions.assertThat(map.get(Rank.NOTHING)).isNull();
    }
}
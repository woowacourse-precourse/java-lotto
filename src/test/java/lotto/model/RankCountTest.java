package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RankCountTest {
    private final List<Lotto> lottos = new ArrayList<>();
    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

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

    @DisplayName("맞춘 개수에 따른 상금의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({"FIRST, 1", "SECOND, 1", "THIRD, 0", "FOURTH, 1", "FIFTH, 1"})
    void countRank(Rank rank, int result) {
        RankCount rankCount = new RankCount(lottos, winningLotto);

        Map<Rank, Integer> countRanks = rankCount.countRank();
        Integer numberOfRank = countRanks.get(rank);

        Assertions.assertThat(numberOfRank.intValue()).isEqualTo(result);
    }
}
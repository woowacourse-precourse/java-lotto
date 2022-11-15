package lotto.domain;

import lotto.util.RankingType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    Lottos lottos;

    @BeforeEach
    void 로또리스트_초기화() {
        lottos =new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(9, 8, 7, 6, 4, 2)),
                new Lotto((Arrays.asList(10, 28, 38, 1, 9, 32)))
        ));
    }

    @Test
    @DisplayName("로또 리스트 출력 검증")
    void 로또_리스트_출력() {
        // given
        // when
        String result = lottos.getLottosString();
        // then
        assertThat(result)
                .isEqualTo("[2, 4, 6, 7, 8, 9]\n[1, 9, 10, 28, 32, 38]");
    }

    @Test
    @DisplayName("로또 리스트로 만들어지는 랭킹 개수 출력 로직 검증")
    void 랭킹_개수() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(2, 4, 6, 1, 9, 10));
        winningLotto.updateBonus(11);
        // when
        Map<RankingType, Integer> result = lottos.getRankingTypeCounts(winningLotto);
        // then
        assertThat(result)
                .isEqualTo(Map.of(RankingType.DROP_OUT, 0,
                        RankingType.FIFTH, 1,
                        RankingType.FOURTH, 1,
                        RankingType.THIRD, 0,
                        RankingType.SECOND, 0,
                        RankingType.FIRST, 0));

    }

}

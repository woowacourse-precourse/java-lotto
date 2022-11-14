package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoGroupTest {

    @DisplayName("로또 그룹 출력 검증")
    @Test
    void 로또_그룹_출력(){
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(9, 8, 7, 6, 4,2)),
                new Lotto((Arrays.asList(10, 28,38, 1, 9, 32)))
        );
        // when
        LottoGroup lottoGroup = new LottoGroup(lottos);
        // then
        assertThat(lottoGroup.getLottosString())
                .isEqualTo("[2, 4, 6, 7, 8, 9]\n[1, 9, 10, 28, 32, 38]");
    }

    @DisplayName("결과 맵 구하기 검증")
    @Test
    void 일등부터_5등까지_한_개씩_출력(){
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)),
                new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11))
        );
        LottoGroup lottoGroup = new LottoGroup(lottos);
        // when
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));
        winningNumber.updateBonus(7);
        // then
        Map<RankingType, Integer> countByRankingType =
                lottoGroup.getCountByRankingType(winningNumber);
        Map<RankingType, Integer> expected =
                Map.of(RankingType.FIRST, 1, RankingType.SECOND,1,
                        RankingType.THIRD, 1, RankingType.FOURTH,1,
                        RankingType.FIFTH ,1, RankingType.DROP_OUT, 1);
        assertThat(countByRankingType).isEqualTo(expected);
    }
}
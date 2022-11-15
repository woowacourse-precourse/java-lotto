package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottiesTest {

    private List<Lotto> lottos;
    private List<Integer> userLotto;

    private Lotties lotties;

    @BeforeEach
    void init() {
        lottos = List.of(
                        new Lotto(List.of(6, 1, 2, 3, 32, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(9, 1, 2, 3, 4, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 32)));
        userLotto = List.of(1, 2, 3, 4, 5, 6);
        lotties = new Lotties(lottos);
    }

    @DisplayName("당첨 맵의 크기는 발행한 로또의 개수와 같아야 한다.")
    @Test
    void getLottoWinMapSize() {
        int publishCount = lottos.size();
        int bonusNum = 32;

        Map<LottoRank, Long> lottoWinMap = lotties.generateLottoRankMap(userLotto, bonusNum);

        assertThat(lottoWinMap.size()).isEqualTo(publishCount-1);
    }

    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"FIRST, 1", "SECOND, 1", "FOURTH, 2"})
    void getMatchCountByLottoAndUserLotto(LottoRank rank, int count) {
        int bonusNum = 32;

        Map<LottoRank, Long> lottoWinMap = lotties.generateLottoRankMap(userLotto, bonusNum);

        assertThat(lottoWinMap.get(rank)).isEqualTo(count);
    }
}

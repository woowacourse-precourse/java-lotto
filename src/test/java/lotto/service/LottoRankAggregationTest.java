package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.RankAggregationDto;
import lotto.dto.WinningLottoNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankAggregationTest {

    @Test
    @DisplayName("")
    void getRankAggregation() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLottoNumberDto winningLottoNumber = WinningLottoNumberDto.createWinningLottoNumber(winningNumbers, bonusNumber);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = List.of(lotto);

        // when
        LottoRankAggregation lottoRankAggregation = new LottoRankAggregation();
        RankAggregationDto result = lottoRankAggregation.getRankAggregation(lottos, winningLottoNumber);

        // then
        int sum = result.getRankAggregationMap().values().stream().mapToInt(Integer::valueOf).sum();
        Optional<Rank> first = result.getRankAggregationMap().entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();

        assertThat(sum).isEqualTo(1);
        assertThat(first.get()).isEqualTo(Rank.FIRST);
    }
}
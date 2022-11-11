package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("결과 EnumMap 초기화 테스트")
    @Test
    void createInitResult() {
        EnumMap<LottoRank, Long> result = Arrays.stream(LottoRank.values())
                .filter(value -> value != LottoRank.NO_MATCH)
                .collect(Collectors.toMap(value -> value, count -> 0L, (a, b) -> b,
                        () -> new EnumMap<>(LottoRank.class)));
        assertThat(new LottoResult()).isEqualTo(new LottoResult(result));
    }

    @DisplayName("로또 결과를 출력한다.")
    @Test
    void createLottoResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 13)),
                new Lotto(List.of(1, 3, 4, 5, 6, 11)),
                new Lotto(List.of(3, 4, 5, 6, 8, 9)),
                new Lotto(List.of(2, 5, 6, 7, 8, 13)),
                new Lotto(List.of(6, 7, 8, 9, 10, 13))
        );
        UserLotto userLotto = new UserLotto(lottos);
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "13");

        EnumMap<LottoRank, Long> result = new EnumMap<>(LottoRank.class);
        result.put(LottoRank.THREE_MATCHES, 1L);
        result.put(LottoRank.FOUR_MATCHES, 1L);
        result.put(LottoRank.FIVE_MATCHES, 1L);
        result.put(LottoRank.FIVE_BONUS_MATCHES, 1L);
        result.put(LottoRank.SIX_MATCHES, 1L);

        assertThat(new LottoResult(userLotto, lottoNumber)).isEqualTo(new LottoResult(result));
    }
}
package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @DisplayName("로또 묶음에서 로또의 개수를 확인한다.")
    @Test
    void size() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        List<Lotto> givenLottos = List.of(lotto);

        // when
        Lottos lottos = new Lottos(givenLottos);

        // then
        assertThat(lottos.size()).isEqualTo(givenLottos.size());
    }

    @DisplayName("출력용 로또 묶음 문자열을 반환한다.")
    @Test
    void returnString() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        List<Lotto> givenLottos = List.of(lotto);

        // when
        Lottos lottos = new Lottos(givenLottos);

        // then
        assertThat(lottos.toString()).isEqualTo(givenLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n")));
    }

    @DisplayName("각 로또의 등수를 알 수 있다.")
    @Test
    void getLottoRanks() {
        // given
        List<Lotto> lotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        Lottos lottos = new Lottos(lotto);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        EnumMap<LottoRank, Integer> lottoRanks = lottos.getLottoRanks(winningLotto, bonusNumber);

        assertThat(lottoRanks.get(LottoRank.FIFTH)).isEqualTo(1);
    }
}

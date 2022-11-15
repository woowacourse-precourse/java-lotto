package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void create() {
        Lottos actual = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        assertThat(actual).isEqualTo(new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 결과를 생성해 반환한다.")
    @Test
    void result() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                new Lotto(List.of(1, 2, 9, 10, 11, 12))
        ));

        WinningLotto winningLotto
                = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBonusNumber.of(7));
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        assertThat(lottos.result(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBonusNumber.of(7))))
                .isEqualTo(lottoResult);
    }

    @DisplayName("로또들을 반환한다.")
    @Test
    void lottos() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                new Lotto(List.of(1, 2, 9, 10, 11, 12))
        ));

        assertThat(lottos.lottos()).containsExactly(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                new Lotto(List.of(1, 2, 9, 10, 11, 12))
        );
    }

    @DisplayName("로또 개수를 반환한다.")
    @Test
    void count() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11))
        ));

        assertThat(lottos.count()).isEqualTo(5);
    }
}

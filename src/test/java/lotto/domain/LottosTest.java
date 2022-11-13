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
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.SECOND);
        lottoResult.addResult(Rank.THIRD);
        lottoResult.addResult(Rank.FOURTH);
        lottoResult.addResult(Rank.FIFTH);
        lottoResult.addResult(Rank.MISS);

        assertThat(lottos.result(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(7))))
                .isEqualTo(lottoResult);
    }
}

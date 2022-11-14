package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        this.winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBonusNumber.of(7));
    }

    @DisplayName("로또 결과를 추가한다.")
    @Test
    void addResult() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        Assertions.assertAll(
                () -> assertThat(lottoResult.rankCount(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(lottoResult.rankCount(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(lottoResult.rankCount(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResult.rankCount(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResult.rankCount(Rank.FIFTH)).isEqualTo(1),
                () -> assertThat(lottoResult.rankCount(Rank.MISS)).isEqualTo(1)
        );

    }

    @DisplayName("총 상금을 반환한다.")
    @Test
    void reward() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        assertThat(lottoResult.reward()).isEqualTo(new Money(2_031_555_000));
    }

    @DisplayName("순위 개수를 반환한다.")
    @Test
    void rankCount() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        assertThat(lottoResult.rankCount(Rank.FIRST)).isEqualTo(3);
    }
}

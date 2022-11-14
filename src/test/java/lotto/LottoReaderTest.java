package lotto;

import static lotto.LottoRank.RANK1;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReaderTest {
    private LottoReader lottoReader;

    @BeforeEach
    void setUp() {
        lottoReader = new LottoReader();
    }

    @DisplayName("로또 당첨 결과를 구합니다.")
    @Test
    void createLottoResult() {
        // given
        List<Lotto> publishedLotto = new ArrayList<>();
        publishedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(10, winningLotto);

        // when
        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedLotto, winningLotto, bonus);

        // then
        assertThat(lottoResult).containsEntry(RANK1, 1);
    }

    @DisplayName("로또 수익률을 구합니다.")
    @Test
    void calculateYield() {
        // given
        List<Lotto> publishedLotto = new ArrayList<>();
        publishedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(10, winningLotto);

        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedLotto, winningLotto,bonus);

        // when
        String lottoYield = lottoReader.calculateYield(1000);

        // then
        assertThat(lottoYield).isEqualTo("200000000.0");
    }
}
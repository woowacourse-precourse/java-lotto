package lotto.model;

import static lotto.model.LottoRank.RANK1;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReaderTest {
    private LottoReader lottoReader;
    private List<Lotto> publishedLotto;
    private Lotto winningLotto;
    private Bonus bonus;

    @BeforeEach
    void setUp() {
        lottoReader = new LottoReader();
        publishedLotto = new ArrayList<>();
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(10, winningLotto);
    }

    @DisplayName("로또 당첨 결과를 구합니다.")
    @Test
    void createLottoResult() {
        // given
        publishedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedLotto, winningLotto, bonus);

        // then
        assertThat(lottoResult).containsEntry(RANK1, 1);
    }

    @DisplayName("로또 수익률을 구합니다.")
    @Test
    void calculateYield() {
        // given
        publishedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedLotto, winningLotto, bonus);

        // when
        double lottoYield = lottoReader.calculateYield(1000);

        // then
        assertThat(lottoYield).isEqualTo(200000000.0);
    }
}
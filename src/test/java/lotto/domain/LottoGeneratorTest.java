package lotto.domain;

import lotto.Model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 로또묶음_개수_테스트() {
        List<Lotto> lottoBundle = lottoGenerator.generateLottoBundle(3000);
        assertThat(lottoBundle.size()).isEqualTo(3);
    }

    @Test
    void 천원단위_오류_테스트() {
        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영원이하_오류_테스트() {
        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
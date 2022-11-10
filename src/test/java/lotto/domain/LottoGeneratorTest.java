package lotto.domain;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void 로또묶음_개수_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoBundle = lottoGenerator.generateLottoBundle(3000);
        assertThat(lottoBundle.size()).isEqualTo(3);
    }

    @Test
    void 천원단위_오류_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영원이하_오류_테스트(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
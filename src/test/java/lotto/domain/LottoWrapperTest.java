package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWrapperTest {
    @Test
    void 저장된_로또가_잘_GET되는지_테스트한다() {
        LottoWrapper lottoWrapper = new LottoWrapper();
        Lotto testLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLotto2 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        lottoWrapper.add(testLotto1);
        lottoWrapper.add(testLotto2);

        Assertions.assertAll(() -> {
            assertThat(lottoWrapper.get(0)).isEqualTo(testLotto1);
            assertThat(lottoWrapper.get(1)).isNotEqualTo(testLotto1);
            assertThat(lottoWrapper.get(1)).isEqualTo(testLotto2);
            assertThat(lottoWrapper.get(1)).isNotEqualTo(testLotto1);
        });
    }

    @Test
    void 로또가_저장됨에_따라_올바른_SIZE를_반환하는지_테스트한다() {
        LottoWrapper lottoWrapper1 = new LottoWrapper();
        LottoWrapper lottoWrapper2 = new LottoWrapper();
        lottoWrapper2.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoWrapper2.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));

        Assertions.assertAll(() -> {
            assertThat(lottoWrapper1.size()).isEqualTo(0);
            assertThat(lottoWrapper2.size()).isEqualTo(2);
        });
    }
}
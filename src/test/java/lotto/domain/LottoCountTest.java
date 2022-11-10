package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    LottoCount lottoCount = new LottoCount();

    @DisplayName("로또 개수 확인 테스트")
    @Test
    void lottoCountComparison() {
        int count = lottoCount.getLottoCount(5000);
        Assertions.assertThat(count).isSameAs(5);
    }
}
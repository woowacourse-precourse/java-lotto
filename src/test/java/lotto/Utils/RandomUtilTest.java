package lotto.Utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomUtilTest {

    @Test
    void 랜덤_리스트_길이_확인() {
        assertThat(RandomUtil.makeRandomNumbers().size()).isEqualTo(6);
    }
}
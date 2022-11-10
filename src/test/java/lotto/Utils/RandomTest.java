package lotto.Utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomTest {

    @Test
    void 랜덤_리스트_길이_확인() {
        assertThat(Random.makeRandomNumbers().size()).isEqualTo(6);
    }
}
package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiesTest {

    @DisplayName("로또를 주어진 개수만큼 발행한다.")
    @Test
    void createLotties() {
        int lottoCount = 3;
        int expected = 3;

        Lotties lotties = Lotties.create(lottoCount);

        Assertions.assertThat(lotties.getLottiesSize()).isEqualTo(expected);
    }
}

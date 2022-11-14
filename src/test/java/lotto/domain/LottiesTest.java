package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiesTest {

    private Lotties lotties;

    @BeforeEach
    void init() {
        int publishCount = 2;
        lotties = Lotties.create(publishCount);
    }

    @DisplayName("로또를 주어진 개수만큼 발행한다.")
    @Test
    void createLotties() {
        int lottoSize = lotties.count();

        Assertions.assertThat(lottoSize).isEqualTo(2);
    }
}

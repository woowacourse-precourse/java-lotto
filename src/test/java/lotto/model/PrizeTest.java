package lotto.model;

import lotto.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    public void 서치툴_동작_테스트() {
        Prize search = Prize.search(3, false);
        Assertions.assertThat(search).isEqualTo(Prize.FIFTH);
    }
}
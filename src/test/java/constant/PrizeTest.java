package constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    public void 서치툴_동작_테스트() {
        Prize search = Prize.search(3, false);
        Assertions.assertThat(search).isEqualTo(Prize.FIFTH);
    }
}
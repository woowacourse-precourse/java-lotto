package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsumerResultTest {
    @Test
    void 수익률_확인(){
        ConsumerResult consumerResult = new ConsumerResult();
        Assertions.assertThat(consumerResult.profit(8000, 5000)).isEqualTo(62.5);

    }

}
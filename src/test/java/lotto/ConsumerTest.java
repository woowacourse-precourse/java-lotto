package lotto;

import lotto.domain.Consumer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConsumerTest {
    @Test
    void 구매_금액_단위_테스트() {
        assertThatThrownBy(() -> {
            Consumer consumer = new Consumer();
            final byte[] buf = String.join("\n", "2002").getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            consumer.purchase();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액_부족_테스트() {
        assertThatThrownBy(() -> {
            Consumer consumer = new Consumer();
            final byte[] buf = String.join("\n", "100").getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            consumer.purchase();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

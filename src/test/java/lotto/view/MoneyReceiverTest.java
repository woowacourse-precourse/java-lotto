package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyReceiverTest {
    @DisplayName("금액을 올바르게 받는지 확인")
    @Test
    void getMoney() {
        String expected = "8_000";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);
        assertThat(MoneyReceiver.getMoney()).isEqualTo(expected);
    }
}

package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberReceiverTest {

    @DisplayName("보너스 번호를 입력받는다.")
    @Test
    void receiveBonusNumber() {
        String expected = "7";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        assertThat(Integer.parseInt(expected)).isEqualTo(BonusNumberReceiver.receiveBonusNumber());
    }
}

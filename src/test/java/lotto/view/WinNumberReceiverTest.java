package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinNumberReceiverTest {
    @DisplayName("당첨번호로 6자리를 입력받는다.")
    @Test
    void WinNumberReceiver() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        InputStream in = new ByteArrayInputStream(expected.toString().getBytes());
        System.setIn(in);
        assertThat(WinNumberReceiver.getWinNumber).isEqual(expected);
    }
}

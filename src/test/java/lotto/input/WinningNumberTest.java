package lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumberTest {
    WinningNumber winningNumber = new WinningNumber();
    List<Integer> testValue = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void putNumberTest() {
        String InputTestCase1 = "1,2,3,4,5,6";
        String InputTestCase2 = "1,2,3,4,5,6,7";

        System.setIn(new ByteArrayInputStream(InputTestCase1.getBytes()));
        assertThat(winningNumber.putNumber()).isEqualTo(testValue);

        System.setIn(new ByteArrayInputStream(InputTestCase2.getBytes()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> winningNumber.putNumber());
    }//putNumberTest
}// end class

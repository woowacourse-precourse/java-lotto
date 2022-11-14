package lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class NumberComparatorTest {
    @Test
    void setWinningNumberTest() {
        String winningNumber = "12, 43, 40, 23, 14, 3";
        List<Integer> expectation = List.of(12, 43, 40, 23, 14, 3);
        NumberComparator tester = new NumberComparator();
        InputStream input = new ByteArrayInputStream(winningNumber.getBytes());

        System.setIn(input);
        tester.setWinningNumber();
        Assertions.assertThat(tester.number).isEqualTo(expectation);
    }
}

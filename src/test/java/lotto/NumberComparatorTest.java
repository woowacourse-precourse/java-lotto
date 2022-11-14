package lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberComparatorTest {
    @Test
    void setWinningNumberTest() {
        String winningNumber = "12, 43, 40, 23, 14, 3";
        List<Integer> expectation = List.of(12, 43, 40, 23, 14, 3);
        NumberComparator tester = new NumberComparator();
        InputStream input = new ByteArrayInputStream(winningNumber.getBytes());

        System.setIn(input);
        tester.setWinningNumber();
        assertThat(tester.number).isEqualTo(expectation);
    }

    @Test
    void setOversizeWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(11, 12, 13, 14, 15, 16, 17));
            tester.validateWinningNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUndersizeWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(21, 12, 42, 5, 15));
            tester.validateWinningNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setRepetitiveWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(45, 42, 42, 4, 1, 14));
            tester.validateWinningNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOverMaxWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(41, 42, 43, 44, 45, 46));
            tester.validateWinningNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUnderMinWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(0, 1, 2, 3, 4, 5));
            tester.validateWinningNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOversizeWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(1, 2, 3, 4, 5, 6, 7, 8));
            tester.validateWholeNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUndersizeWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(3, 23, 35, 43, 12, 32));
            tester.validateWholeNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setRepetitiveWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(32, 32, 12, 43, 5, 2, 3));
            tester.validateWholeNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOverMaxWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(40, 41, 42, 43, 44, 45, 46));
            tester.validateWholeNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUnderMinWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(0, 1, 2, 3, 4, 5, 6));
            tester.validateWholeNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}

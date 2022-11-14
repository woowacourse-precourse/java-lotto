package lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
    void setRepetitiveWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(32, 32, 12, 43, 5, 2));

            tester.bonus = 12;
            tester.validateBonus();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOverMaxWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(40, 41, 42, 43, 44, 45));

            tester.bonus = 46;
            tester.validateBonus();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUnderMinWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(1, 2, 3, 4, 5, 6));

            tester.bonus = 0;
            tester.validateBonus();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareNumberTest() {
        Lotto lotto1 = new Lotto(List.of(43, 21, 30, 42, 33, 1));
        Lotto lotto2 = new Lotto(List.of(5, 4, 3, 2, 1, 45));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto5 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        LottoSeller seller = new LottoSeller(List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
        NumberComparator tester = new NumberComparator(List.of(1,2,3,4,5,6));
        tester.bonus = 7;

        seller.showBundle();
        System.out.println(tester.number);
        tester.compareNumbers(seller.get());
        assertThat(tester.result).isEqualTo(List.of(1, 5, 6, 7, 0));
    }
}

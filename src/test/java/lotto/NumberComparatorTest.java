package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberComparatorTest {
    @Test
    void setOversizeWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(11, 12, 13, 14, 15, 16, 17), 35);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUndersizeWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(21, 12, 42, 5, 15), 33);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setRepetitiveWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(45, 42, 42, 4, 1, 14), 13);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOverMaxWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(41, 42, 43, 44, 45, 46), 3);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUnderMinWinningNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(0, 1, 2, 3, 4, 5), 24);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setRepetitiveWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(32, 32, 12, 43, 5, 2), 12);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setOverMaxWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(40, 41, 42, 43, 44, 45), 46);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUnderMinWholeNumber() {
        assertThatThrownBy(() -> {
            NumberComparator tester = new NumberComparator(List.of(1, 2, 3, 4, 5, 6), 0);
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
        NumberComparator tester = new NumberComparator(List.of(1,2,3,4,5,6), 7);

        tester.compareNumber(seller.getBundle());
        assertThat(tester.getResult()).isEqualTo(List.of(1, 5, 6, 7, 0));
    }
}

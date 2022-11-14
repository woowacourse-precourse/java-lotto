package lotto;

import org.junit.jupiter.api.Test;
import lotto.Application.Places;
import static lotto.Application.compareResult;
import static org.assertj.core.api.Assertions.assertThat;

class CompareResultMethodTest {
    @Test
    void compareResult_메소드_테스트1() {
        assertThat(compareResult(0, false)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트2() {
        assertThat(compareResult(0, true)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트3() {
        assertThat(compareResult(1, false)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트4() {
        assertThat(compareResult(1, true)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트5() {
        assertThat(compareResult(2, false)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트6() {
        assertThat(compareResult(2, true)).isEqualTo(Places.NONE);
    }

    @Test
    void compareResult_메소드_테스트7() {
        assertThat(compareResult(3, false)).isEqualTo(Places.FIFTH);
    }

    @Test
    void compareResult_메소드_테스트8() {
        assertThat(compareResult(3, true)).isEqualTo(Places.FIFTH);
    }

    @Test
    void compareResult_메소드_테스트9() {
        assertThat(compareResult(4, false)).isEqualTo(Places.FOURTH);
    }

    @Test
    void compareResult_메소드_테스트10() {
        assertThat(compareResult(4, true)).isEqualTo(Places.FOURTH);
    }

    @Test
    void compareResult_메소드_테스트11() {
        assertThat(compareResult(5, false)).isEqualTo(Places.THIRD);
    }

    @Test
    void compareResult_메소드_테스트12() {
        assertThat(compareResult(5, true)).isEqualTo(Places.SECOND);
    }

    @Test
    void compareResult_메소드_테스트13() {
        assertThat(compareResult(6, false)).isEqualTo(Places.FIRST);
    }
}
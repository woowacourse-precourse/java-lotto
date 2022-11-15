package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.Application.Places;
import static lotto.Application.compareResult;
import static org.assertj.core.api.Assertions.assertThat;

class CompareResultMethodTest {
    @DisplayName("당첨 번호 0개, 보너스 번호 0개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest1() {
        assertThat(compareResult(0, false)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 0개, 보너스 번호 1개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest2() {
        assertThat(compareResult(0, true)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 1개, 보너스 번호 0개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest3() {
        assertThat(compareResult(1, false)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 1개, 보너스 번호 1개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest4() {
        assertThat(compareResult(1, true)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 2개, 보너스 번호 0개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest5() {
        assertThat(compareResult(2, false)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 2개, 보너스 번호 1개는 당첨 순위에 해당하지 않는다.")
    @Test
    void compareResultMethodTest6() {
        assertThat(compareResult(2, true)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 번호 3개, 보너스 번호 0개는 5등에 해당한다.")
    @Test
    void compareResultMethodTest7() {
        assertThat(compareResult(3, false)).isEqualTo(Places.FIFTH);
    }

    @DisplayName("당첨 번호 3개, 보너스 번호 1개는 5등에 해당한다.")
    @Test
    void compareResultMethodTest8() {
        assertThat(compareResult(3, true)).isEqualTo(Places.FIFTH);
    }

    @DisplayName("당첨 번호 4개, 보너스 번호 0개는 4등에 해당한다.")
    @Test
    void compareResultMethodTest9() {
        assertThat(compareResult(4, false)).isEqualTo(Places.FOURTH);
    }

    @DisplayName("당첨 번호 4개, 보너스 번호 1개는 4등에 해당한다.")
    @Test
    void compareResultMethodTest10() {
        assertThat(compareResult(4, true)).isEqualTo(Places.FOURTH);
    }

    @DisplayName("당첨 번호 5개, 보너스 번호 0개는 3등에 해당한다.")
    @Test
    void compareResultMethodTest11() {
        assertThat(compareResult(5, false)).isEqualTo(Places.THIRD);
    }

    @DisplayName("당첨 번호 5개, 보너스 번호 1개는 2등에 해당한다.")
    @Test
    void compareResultMethodTest12() {
        assertThat(compareResult(5, true)).isEqualTo(Places.SECOND);
    }

    @DisplayName("당첨 번호 6개, 보너스 번호 0개는 1등에 해당한다.")
    @Test
    void compareResultMethodTest13() {
        assertThat(compareResult(6, false)).isEqualTo(Places.FIRST);
    }
}
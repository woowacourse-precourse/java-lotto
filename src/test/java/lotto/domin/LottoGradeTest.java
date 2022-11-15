package lotto.domin;

import lotto.domain.LottoGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGradeTest {

    @Test
    @DisplayName("일치하는 번호가 5개이고, 보너스 볼이 일치하면 TWO가 반환된다.")
    void lottoGetRankTwo() {
        assertThat(LottoGrade.getRank(5, true)).isEqualTo(LottoGrade.TWO);
    }

    @Test
    @DisplayName("일치하는 번호가 5개이고, 보너스 볼이 일치하지 않으면 THREE가 반환된다.")
    void lottoGetRankThree() {
        assertThat(LottoGrade.getRank(5, false)).isEqualTo(LottoGrade.THREE);
    }

    @Test
    @DisplayName("일치하는 번호가 6개이면 ONE을 반환한다.")
    void lottoGetRankOne() {
        assertThat(LottoGrade.getRank(6, false)).isEqualTo(LottoGrade.ONE);
    }

    @Test
    @DisplayName("일치하는 번호가 4개이고, 보너스 볼이 일치해도 FOUR를 반환한다.")
    void lottoGetRankFour() {
        assertThat(LottoGrade.getRank(4, true)).isEqualTo(LottoGrade.FOUR);
    }
}

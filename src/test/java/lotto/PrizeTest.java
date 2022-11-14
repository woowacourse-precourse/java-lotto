package lotto;

import lotto.domian.statistics.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @DisplayName("enum 변수에 맞는 등수를 숫자로 반환한다.")
    @Test
    void getGradeNum() {
        // given
        int gradeNum = Prize.getGradeNum(Prize.FIRST);

        // then
        assertThat(gradeNum).isEqualTo(1);
    }

    @DisplayName("enum 변수에 맞는 상금을 반환한다.")
    @Test
    void getPrice() {
        // given
        int price = Prize.getPrice(Prize.FIRST);

        // then
        assertThat(price).isEqualTo(2_000_000_000);
    }
}

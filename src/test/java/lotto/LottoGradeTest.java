package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoGrade Enum의")
public class LottoGradeTest {
    @Nested
    @DisplayName("getMatchGrade 메서드는")
    class describe_getNumberFromUser {

        @Nested
        @DisplayName("일치하는 숫자의 개수와 보너스 숫자 일치 여부를 받아")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 등수 객체를 반환한다.")
            void return_number_when_receive_right_input() {
                Assertions.assertThat(LottoGrade.getMatchGrade(6,false)).isEqualTo(LottoGrade.FIRST);
                Assertions.assertThat(LottoGrade.getMatchGrade(5,true)).isEqualTo(LottoGrade.SECOND);
                Assertions.assertThat(LottoGrade.getMatchGrade(5,false)).isEqualTo(LottoGrade.THIRD);
                Assertions.assertThat(LottoGrade.getMatchGrade(4,false)).isEqualTo(LottoGrade.FOURTH);
                Assertions.assertThat(LottoGrade.getMatchGrade(3,false)).isEqualTo(LottoGrade.FIFTH);
                Assertions.assertThat(LottoGrade.getMatchGrade(2,false)).isEqualTo(LottoGrade.FAIL);
                Assertions.assertThat(LottoGrade.getMatchGrade(2,true)).isEqualTo(LottoGrade.FAIL);
            }
        }
    }
}

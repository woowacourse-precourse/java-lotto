package lotto.domain;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeTest {

    @Test
    @DisplayName("당첨 번호, 보너스 번호 일치 여부에 따른 등수를 올바르게 판별한다.")
    void findingRank() {
        assertThat(Grade.findGrade(6,0)).isEqualTo(Grade.FIRST);
        assertThat(Grade.findGrade(5,1)).isEqualTo(Grade.SECOND);
        assertThat(Grade.findGrade(5,0)).isEqualTo(Grade.THIRD);
        assertThat(Grade.findGrade(4,0)).isEqualTo(Grade.FOURTH);
        assertThat(Grade.findGrade(3,0)).isEqualTo(Grade.FIFTH);
        assertThat(Grade.findGrade(0,0)).isNull();
    }

    @Test
    @DisplayName("유효하지 않은 Key 값이면 예외가 발생한다.")
    void findGradeByInvalidKeyThrowError() {
        assertThatThrownBy(() -> Grade.findGradeByKey("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 Key 입니다.");
    }
}

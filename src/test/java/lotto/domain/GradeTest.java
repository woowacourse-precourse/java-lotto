package lotto.domain;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeTest {

    @Test
    @DisplayName("당첨 번호, 보너스 번호 일치 여부에 따른 등수를 올바르게 판별한다.")
    void findingRank() {
        assertThat(Grade.findingGrade(6,0)).isEqualTo(Grade.FIRST);
        assertThat(Grade.findingGrade(5,1)).isEqualTo(Grade.SECOND);
        assertThat(Grade.findingGrade(5,0)).isEqualTo(Grade.THIRD);
        assertThat(Grade.findingGrade(4,0)).isEqualTo(Grade.FOURTH);
        assertThat(Grade.findingGrade(3,0)).isEqualTo(Grade.FIFTH);
        assertThat(Grade.findingGrade(0,0)).isNull();
    }
}

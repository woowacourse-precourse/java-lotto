package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradeTest {

    @DisplayName("당첨 결과 테스트")
    @Test
    void getGrade() {
        boolean haveBonusNumber = true;

        assertAll(
            () -> assertThat(Grade.getGrade(6, !haveBonusNumber)).isEqualTo(Grade.FIRST),
            () -> assertThat(Grade.getGrade(5, haveBonusNumber)).isEqualTo(Grade.SECOND),
            () -> assertThat(Grade.getGrade(5, !haveBonusNumber)).isEqualTo(Grade.THIRD),
            () -> assertThat(Grade.getGrade(4, !haveBonusNumber)).isEqualTo(Grade.FOURTH),
            () -> assertThat(Grade.getGrade(3, !haveBonusNumber)).isEqualTo(Grade.FIFTH),
            () -> assertThat(Grade.getGrade(2, !haveBonusNumber)).isNull(),
            () -> assertThat(Grade.getGrade(1, !haveBonusNumber)).isNull(),
            () -> assertThat(Grade.getGrade(0, !haveBonusNumber)).isNull()
        );
    }

    @DisplayName("당첨 등수의 개수는 5개")
    @Test
    void getAllGrades() {
        assertThat(Grade.getAllGrades()).hasSize(5);
    }

}

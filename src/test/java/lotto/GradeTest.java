package lotto;

import lotto.domain.result.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeTest {

    @DisplayName("Grade valueOf() 기능 테스트")
    @Test
    void gradeValueOfTest1() {
        Grade result = Grade.NONE;

        assertThat(Grade.valueOf(1, false)).isEqualTo(result);
    }

    @DisplayName("Grade valueOf() 기능 테스트")
    @Test
    void gradeValueOfTest2() {
        Grade result = Grade.FIFTH;

        assertThat(Grade.valueOf(3, true)).isEqualTo(result);
    }

    @DisplayName("Grade valueOf() 기능 테스트")
    @Test
    void gradeValueOfTest3() {
        Grade result = Grade.FOURTH;

        assertThat(Grade.valueOf(4, false)).isEqualTo(result);
    }

    @DisplayName("Grade valueOf() 기능 테스트")
    @Test
    void gradeValueOfTest5() {
        Grade result = Grade.SECOND;

        assertThat(Grade.valueOf(5, true)).isEqualTo(result);
    }
}

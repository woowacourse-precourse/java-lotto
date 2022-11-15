package lotto;

import lotto.domian.statistics.Grade;
import lotto.domian.statistics.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeTest {
    @DisplayName("발행한 로또에서 당첨 번호의 수를 센 후 개수를 출력한다.")
    @Test
    void countCorrectNumbers() {
        // given
        Grade grade = new Grade(List.of(1, 2, 3, 10, 22, 12), 3);

        // when
        int count = grade.countCorrectNumbers(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("발행한 로또에 보너스 번호 존재 유무를 확인한다.")
    @Test
    void checkLottoNumbersContainBonusNumber() {
        // given
        Grade grade = new Grade(List.of(1, 2, 3, 4, 5, 6),3);

        // when
        Prize result = grade.checkLottoNumbersContainBonusNumber(List.of(1, 2, 3, 10, 22, 12));

        // then
        assertThat(result).isEqualTo(Prize.SECOND);
    }

    @DisplayName("발행한 로또의 등수를 확인한다.")
    @Test
    void checkLottoGrade() {
        // given
        Grade grade = new Grade(List.of(1, 2, 3, 4, 5, 6), 3);

        // when
        Prize result = grade.checkLottoGrade(6);

        // then
        assertThat(result).isEqualTo(Prize.FIRST);
    }

    @DisplayName("발행한 로또의 등수를 반환한다.")
    @Test
    void returnLottoGrade() {
        // given
        Grade grade = new Grade(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Prize result = grade.returnLottoGrade(List.of(1, 2, 3, 4, 5, 7));

        // then
        assertThat(result).isEqualTo(Prize.SECOND);
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest {

    @DisplayName("당첨 카운트와 보너스 넘버의 값의 따른 등수 반환")
    @ParameterizedTest
    @CsvSource(value = {"2,true,PASS","3,false,FIFTH","4,false,FORTH","5,false,THIRD","5,true,SECOND","6,true,FIRST"})
    void ofTest(int hitCount, boolean bonusNumber, Grade grade) {
        assertThat(Grade.of(hitCount, bonusNumber)).isEqualTo(grade);
    }

}
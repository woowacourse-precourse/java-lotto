package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    Validate validate = new Validate();

    @DisplayName("1과 45 사이의 숫자인제 확인")
    @Test
    void wrongNumberTest() {
        int minusNumber = -1;
        int wrongNumber = 46;
        int correctNumber = 45;

        boolean minus = validate.wrongNumber(minusNumber);
        boolean wrong = validate.wrongNumber(wrongNumber);
        boolean correct = validate.wrongNumber(correctNumber);

        assertThat(minus).isEqualTo(true);
        assertThat(wrong).isEqualTo(true);
        assertThat(correct).isEqualTo(false);
    }
}
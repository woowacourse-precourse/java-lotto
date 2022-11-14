package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ChangeNumberTypeTest {

    @DisplayName("숫자가 아닌 수를 넣었을때 예외가 발생한다.")
    @Test
    void changeNumberByNotNumber() {
        String number = "112+";
        ChangeNumberType changeNumberType = new ChangeNumberType(number);

        assertThatThrownBy(() -> changeNumberType.getNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 수들을 넣었을때 예외가 발생한다.")
    @Test
    void changeNumberByNotNumbers() {
        String number = "1,2,3,+,5,6";
        ChangeNumberType changeNumberType = new ChangeNumberType(number);

        assertThatThrownBy(() -> changeNumberType.getNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
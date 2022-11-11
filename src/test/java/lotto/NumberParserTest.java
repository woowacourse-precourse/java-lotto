package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import controller.NumberParser;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    @DisplayName("당첨 번호가 6개 미만이면 예외가 발생한다.")
    @Test
    void InputBonusNumbersOverSix(){
        assertThatThrownBy(() -> new NumberParser(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void InputInvalidString(){
        assertThatThrownBy(() -> new NumberParser(List.of(46, 2, 4, 5, 17, 51)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

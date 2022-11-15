package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {

    @Test
    @DisplayName("")
    void isBonusNumber() {

    }

    @Test
    @DisplayName("보너스 번호가 없는 경우")
    void validateEmptyTest() {
        assertThatThrownBy(() -> new LottoBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력을 하지 않았습니다.");
    }

    @Test
    @DisplayName("보너스 번호에 공백이 포함되는 경우")
    void validateBlankTest() {
        assertThatThrownBy(() -> new LottoBonusNumber("1 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우")
    void validateBonusNumberTypeTest() {
        assertThatThrownBy(() -> new LottoBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 보너스 번호는 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("보너스 번호가 45보다 클 경우 확인")
    void validateNumberSizeFirstTest() {
        assertThatThrownBy(() -> new LottoBonusNumber("49"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 보너스 번호는 숫자가 너무 큽니다");
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작을 경우 확인")
    void validateNumberSizeTest() {
        assertThatThrownBy(() -> new LottoBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 보너스 번호는 숫자가 너무 작습니다");
    }

}
package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyDtoTest {
    @DisplayName("정상적으로 생성된다.")
    @Test
    public void createDto() {
        String money = "1000";
        assertThat(new MoneyDto(money))
                .isInstanceOf(MoneyDto.class);
    }

    @DisplayName("금액이 빈칸인 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByEmpty() {
        String money = "";
        assertThatIllegalArgumentException().isThrownBy(() -> new MoneyDto(money))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }

    @DisplayName("금액이 null인 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByNull() {
        String money = null;
        assertThatIllegalArgumentException().isThrownBy(() -> new MoneyDto(money))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }

    @DisplayName("금액이 0보다 큰 1000단위 정수가 아닌경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByNumberForm() {
        String money = "1100";
        assertThatIllegalArgumentException().isThrownBy(() -> new MoneyDto(money))
                .withMessage("금액은 0보다 큰 1000원 단위로만 입력할 수 있습니다.");
    }
}
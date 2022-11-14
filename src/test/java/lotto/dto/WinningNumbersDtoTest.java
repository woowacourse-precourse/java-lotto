package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersDtoTest {
    @DisplayName("정상적으로 생성된다.")
    @Test
    public void createDto() {
        String winningNumbers = "1,2,3,4,5,6";

        assertThat(new WinningNumbersDto(winningNumbers))
                .isInstanceOf(WinningNumbersDto.class);
    }

    @DisplayName("중복되는 숫자가 있는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByDuplicate() {
        String winningNumbers = "1,2,3,4,6,6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbersDto(winningNumbers))
                .withMessage("당첨 번호는 중복없는 6개의 값이어야 합니다.");
    }

    @DisplayName("6개의 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateBySize() {
        String winningNumbers = "1,2,3,4,5,6,7";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbersDto(winningNumbers))
                .withMessage("당첨 번호는 중복없는 6개의 값이어야 합니다.");
    }

    @DisplayName("구분자 콤마(,)가 없는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByDelimiter() {
        String winningNumbers = "12345";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbersDto(winningNumbers))
                .withMessage("당첨 번호는 콤마(,)로 구분해야 합니다.");
    }

    @DisplayName("빈칸이 있는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByEmpty() {
        String winningNumbers = "1,2,3,4,,5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbersDto(winningNumbers))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }

    @DisplayName("1~45 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByRange() {
        String winningNumbers = "1,2,3,4,5,46";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbersDto(winningNumbers))
                .withMessage("당첨 번호는 1 ~ 45 사이 숫자여야 합니다.");
    }
}
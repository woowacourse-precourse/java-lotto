package lotto.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusNumberDtoTest {
    private WinningNumbersDto winningNumbersDto;

    @BeforeEach
    public void setup() {
        String winningNumbers = "1,2,3,4,5,6";
        winningNumbersDto = new WinningNumbersDto(winningNumbers);
    }

    @DisplayName("정상적으로 생성된다.")
    @Test
    public void createDto() {
        String bonusNumber = "7";

        assertThat(new BonusNumberDto(bonusNumber, winningNumbersDto))
                .isInstanceOf(BonusNumberDto.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByDuplicate() {
        String bonusNumber = "6";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumberDto(bonusNumber, winningNumbersDto))
                .withMessage("보너스 번호는 당첨 번호와 다른 값이어야 합니다.");
    }

    @DisplayName("보너스 번호가 빈칸인 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByEmpty() {
        String bonusNumber = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumberDto(bonusNumber, winningNumbersDto))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호가 null인 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByNull() {
        String bonusNumber = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumberDto(bonusNumber, winningNumbersDto))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1 ~ 45 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    public void validateByRange() {
        String bonusNumber46 = "46";
        String bonusNumber0 = "0";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumberDto(bonusNumber46, winningNumbersDto))
                .withMessage("보너스 번호는 1 ~ 45 사이 숫자여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumberDto(bonusNumber0, winningNumbersDto))
                .withMessage("보너스 번호는 1 ~ 45 사이 숫자여야 합니다.");
    }
}
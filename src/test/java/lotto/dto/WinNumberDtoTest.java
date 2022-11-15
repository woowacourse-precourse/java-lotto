package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.data.dto.WinNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 입력에 대해서,")
public class WinNumberDtoTest {

    @DisplayName("입력은 쉼표로 구분되어 있어야 한다.")
    @Test
    void createWinNumberWithoutComma() {
        assertThatThrownBy(() -> WinNumberDto.createWithInput("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력은 숫자와 쉼표로만 이루어져 있어야 한다.")
    @Test
    void createWinNumberWithExtraInput() {
        assertThatThrownBy(() -> WinNumberDto.createWithInput("a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

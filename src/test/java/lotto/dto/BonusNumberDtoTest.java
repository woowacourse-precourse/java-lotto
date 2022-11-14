package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.data.dto.BonusNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("보너스 번호 입력에 대해서,")
public class BonusNumberDtoTest {

    @DisplayName("입력은 숫자만 받는다.")
    @Test
    void createBonusNumberWithoutNumber() {
        assertThatThrownBy(() -> BonusNumberDto.createWithInput("일"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

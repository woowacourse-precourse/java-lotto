package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.data.dto.LottoBundleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구매 입력에 대해서,")
public class LottoBundleDtoTest {

    @DisplayName("입력은 숫자만 받는다.")
    @Test
    void creatLottoBundleWithKoreanNumber() {
        assertThatThrownBy(() -> LottoBundleDto.createWithInput("천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력은 천원 단위로 받는다.")
    @Test
    void createLottoBundleWithIndivisibleNumber() {
        assertThatThrownBy(() -> LottoBundleDto.createWithInput("9999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

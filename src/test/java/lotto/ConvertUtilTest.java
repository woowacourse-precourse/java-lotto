package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class ConvertUtilTest {
    ConvertUtil convertUtil = new ConvertUtil();

    @DisplayName("구입 금액과 보너스 번호로 입력된 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputValueByNotInteger() {
        assertThatThrownBy(() -> convertUtil.StringIntoInt("AAA"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 리스트 변환 테스트")
    @Nested
    class convertList {
        @DisplayName("당첨 번호가 쉼표 기준으로 입력되지 않으면 예외가 발생한다.")
        @Test
        void inputWinningNumberIsNotDividedIntoComma() {
            assertThatThrownBy(() -> convertUtil.StringIntoList("0.1.10.15.20.30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("당첨 번호가 쉼표 사이에 숫자 형식으로 입력되지 않으면 예외가 발생한다.")
        @Test
        void inputWinningNumberContainsNotNumberTypeElement() {
            assertThatThrownBy(() -> convertUtil.StringIntoList("0,1,10,A,20,30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("쉼표 사이에 값이 비어있으면 예외가 발생한다.")
        @Test
        void inputWinningNumberContainsBlackElement() {
            assertThatThrownBy(() -> convertUtil.StringIntoList("0,1,10,,20,30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}

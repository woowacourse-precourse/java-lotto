package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Nested
    @DisplayName("보너스 번호 관련 검증 로직")
    class ValidateBonus{
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1,2,3,4,5,6));

        @Test
        @DisplayName("중복 숫자 입력시 예외 발생")
        void 중복_숫자(){
            // given
            int bonus = 1;
            // when
            // then
            assertThatThrownBy(() -> winningNumber.updateBonus(bonus))
                            .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("범위 벗어난 숫자 입력시 예외 발생")
        void 범위_벗어난_숫자(){
            // given
            int bonus = 49;
            // when
            // then
            assertThatThrownBy(() -> winningNumber.updateBonus(bonus))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}

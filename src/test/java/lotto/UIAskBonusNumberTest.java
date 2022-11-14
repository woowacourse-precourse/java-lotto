package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import camp.nextstep.edu.missionutils.test.NsTest;

class UIAskBonusNumberTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	
	@DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void ShouldBeNumber() {
        assertThatThrownBy(() -> new BonusNumber("a", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
	
	@DisplayName("입력값이 1-45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void ShouldBeNumbersOneToFortyFive() {
        assertThatThrownBy(() -> new BonusNumber("50", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

	@DisplayName("입력 숫자 6개와 보너스 번호가 중복되는 경우 예외가 발생한다.")
    @Test
    void NoDuplicateBonusNumber() {
        assertThatThrownBy(() -> new BonusNumber("3", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}

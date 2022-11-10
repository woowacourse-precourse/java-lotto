package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.BonusNumber;

public class BonusNumberTest {

    @DisplayName("범위를 벗어난 값이 들어왔을 경우")
    @ParameterizedTest(name = "{index} {displayName} input = {0}")
    @ValueSource(ints = {-1, 0, 46})
    void checkBonusNumberException(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46"})
    public void notLottoNumberRange_test(String userInput) {
        assertThatThrownBy(()-> {
            LottoException.notLottoNumberRangeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

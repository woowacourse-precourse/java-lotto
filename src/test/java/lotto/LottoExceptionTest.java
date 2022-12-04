package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoExceptionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void notLottoNumberRange_test(int userInput) {
        assertThatThrownBy(()-> {
            LottoException.notLottoNumberRangeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

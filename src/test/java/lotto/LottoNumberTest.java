package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 51, 0})
    void if_out_range(int number) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(number));
    }
}

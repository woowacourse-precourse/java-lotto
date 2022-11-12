package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 51, 0})
    void if_out_range(int number) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(number));
    }

    @Test
    void equals(){
        LottoNumber lottoNumber = new LottoNumber(1);
        LottoNumber lottoNumber1 = new LottoNumber(1);

        assertTrue(lottoNumber.equals(lottoNumber1));
    }

}

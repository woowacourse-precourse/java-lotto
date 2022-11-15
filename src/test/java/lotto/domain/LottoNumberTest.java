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
//        assertThrows(IllegalArgumentException.class, () -> LottoNumber.lottoNumber(number));
        LottoNumber lottoNumber = LottoNumber.lottoNumber(46);
        System.out.println(lottoNumber);
    }

    @Test
    void equals(){
        LottoNumber lottoNumber = LottoNumber.lottoNumber(1);
        LottoNumber lottoNumber1 = LottoNumber.lottoNumber(1);

        assertTrue(lottoNumber.equals(lottoNumber1));
    }

}

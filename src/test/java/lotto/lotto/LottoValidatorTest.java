package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @Test
    void 로또_숫자_정상범위_테스트() {
        LottoValidator.validateLottoNumber("43");
    }

    @Test
    void 로또_숫자_비정상범위_테스트() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateLottoNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateLottoNumber("46"));
    }

    @Test
    void 로또_답_정상값_파싱_테스트() {
        List<Integer> outputs = LottoValidator.parseCommaString("1,2,3,4,5,6");

        for(int i = 0; i < 6; i++) {
            assertEquals(outputs.get(i), i + 1);
        }
    }

    @Test
    void 로또_답_정상값_파싱_테스트2() {
        List<Integer> outputs = LottoValidator.parseCommaString("31,32,33,34,35,36");

        for(int i = 0; i < 6; i++) {
            assertEquals(outputs.get(i), i + 31);
        }
    }

    @Test
    void 로또_답_입력_format이_이상한_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.parseCommaString("1,2,3,4,5,"));
    }

    @Test
    void 로또_답_입력_format이_이상한_경우_테스트1() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.parseCommaString(",2,3,4,5,6"));
    }

    @Test
    void 로또_답_입력_format이_이상한_경우_테스트2() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.parseCommaString("1,2,3,,4,5,6"));
    }
}
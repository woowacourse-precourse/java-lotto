package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 로또번호_범위테스트() throws Exception {
        // given
        int inputNumber = 34;

        // when
        LottoNumber lottoNumber = new LottoNumber(inputNumber);

        //then
        assertThat(lottoNumber.getLottoNumber())
                .isEqualTo(inputNumber);
    }

    @Test
    void 로또번호_범위테스트_예외() throws Exception {
        // given
        int outRangeNumber = 55;

        // when

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(outRangeNumber))
                .withMessage("[ERROR] 1~45 사이의 수를 입력해 주세요");
    }

    @Test
    void 로또번호_동일_테스트() throws Exception {
        //given
        int inputNumber = 34;

        //when
        LottoNumber baseNumber = new LottoNumber(inputNumber);
        LottoNumber compareNumber = new LottoNumber(inputNumber);

        //then
        assertThat(baseNumber.equals(compareNumber))
                .isTrue();
    }

    @Test
    void 로또번호_동일_테스트_예외() throws Exception {
        //given
        int baseInputNumber = 34;
        int compareInputNumber = 35;

        //when
        LottoNumber baseNumber = new LottoNumber(baseInputNumber);
        LottoNumber compareNumber = new LottoNumber(compareInputNumber);

        //then
        assertThat(baseNumber.equals(compareNumber))
                .isFalse();
    }
}
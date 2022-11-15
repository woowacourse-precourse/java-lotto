package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    final int LOTTO_START_ONE = 1;
    final int LOTTO_END_SEVEN = 7;
    final int LOTTO_END_SIX = 6;
    private final String WARM_NOT_ALLOW_OVERLAP_NUMBER = "[ERROR] 중복된 수가 입력되었습니다.";


    @Test
    void 로또번호_범위테스트() throws Exception {
        //given
        List<LottoNumber> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SEVEN; i++) {
            temp.add(new LottoNumber(i));
        }

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(temp);

        //then
        assertThat(lottoNumbers.getLottoNumbers())
                .contains(temp.get(0), temp.get(1), temp.get(2), temp.get(3), temp.get(4), temp.get(5));
    }

    @Test
    void 로또번호_범위테스트_예외() throws Exception {
        //given
        int duplicateNumber = 5;
        List<LottoNumber> temp = new ArrayList<>();
        // 1~5
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SIX; i++) {
            temp.add(new LottoNumber(i));
        }
        // 5(중복된 숫자)
        temp.add(new LottoNumber(duplicateNumber));

        //when

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(temp))
                .withMessage(WARM_NOT_ALLOW_OVERLAP_NUMBER);
    }

}
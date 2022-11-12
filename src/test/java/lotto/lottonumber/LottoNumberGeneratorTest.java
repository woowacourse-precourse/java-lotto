package lotto.lottonumber;

import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.lottonumber.LottoNumberGenerator.generateLotto;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * LottoNumberGenerator 클래스와 관련된 테스트 클래스입니다.
 */
class LottoNumberGeneratorTest {

    /**
     * 정상적으로 여러 장의 로또가 생성되는지 테스트합니다.
     */
    @Test
    void generateLottoTest() {
        List<LottoNumber> lottoNumbers = generateLotto(100);
        assertThat(lottoNumbers.size()).isEqualTo(100);
        for (int i = 0; i < 100; i++) {
            assertThat(lottoNumbers.get(i).getGeneralLottoNumber().getNumbers().size()).isEqualTo(6);
            assertThat(lottoNumbers.get(i).getBonusLottoNumber()).isGreaterThanOrEqualTo(1);
            assertThat(lottoNumbers.get(i).getBonusLottoNumber()).isLessThanOrEqualTo(45);
        }
    }
}
package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoRandomTest {
    private LottoRandom lottoRandom = new LottoRandom();

    @Nested
    @DisplayName("랜덤 수를 생성한다.")
    class PickUniqueNumbersTest {
        @Test
        void 갯수_테스트() {
            assertThat(lottoRandom.pickUniqueNumbers().size()).isEqualTo(LottoConstants.LOTTO_TICKET_SIZE);
        }

        @Test
        void 숫자_범위_테스트() {
            List<Integer> lottoNumbers = lottoRandom.pickUniqueNumbers();
            assertThat(lottoNumbers.stream().allMatch(
                    n -> n >= LottoConstants.LOTTO_NUMBER_MIN && n <= LottoConstants.LOTTO_NUMBER_MAX)).isEqualTo(true);
        }

        @Test
        void 숫자_중복_테스트() {
            List<Integer> lottoNumbers = lottoRandom.pickUniqueNumbers();
            assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(LottoConstants.LOTTO_TICKET_SIZE);
        }
    }

}
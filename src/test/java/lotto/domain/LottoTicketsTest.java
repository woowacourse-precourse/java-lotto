package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.LottoTickets;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

    @DisplayName("생성한 로또의 개수를 검증한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    void checkLottoTicketsCount(int lottoCount) {
        // given & when
        LottoTickets lottoTickets = new LottoTickets(lottoCount, new LottoNumberGenerator());

        // then
        assertThat(lottoTickets.getCount()).isEqualTo(lottoCount);
    }
}

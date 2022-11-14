package lotto;

import lotto.domain.LottoCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {

    LottoCalculator lottoCalculator;

    // 구매 가능한 티켓 개수를 구하는 메서드 체크
    @ParameterizedTest
    @ValueSource(ints = {8000, 16000, 25000, 3000})
    void 구매_가능한_티켓_개수_확인(int budget){
        lottoCalculator = new LottoCalculator(budget);
        assertThat(lottoCalculator.getTicketSize()).isEqualTo((int)budget / 1000);
    }


    // 이익을 구하는 메서드 체크
}

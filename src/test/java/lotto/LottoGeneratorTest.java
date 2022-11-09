package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final int MONEY_FOR_CREATE_EIGHT_LOTTO = 8000;

    private LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("1000원당 1개의 로또를 생성한다.")
    @Test
    void test1() {
        List<Lotto> lottoTickets = lottoGenerator.createLottoTickets(MONEY_FOR_CREATE_EIGHT_LOTTO);
        assertThat(lottoTickets.size()).isEqualTo(8);
    }
}
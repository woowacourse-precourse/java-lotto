package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    public void setUp() {
        generator = new LottoGenerator();
    }

    @DisplayName("티켓 한 장을 생성하는지 확인")
    @Test
    public void 로또_한_장을_생성하는지_확인()  {
        LottoTickets lottoTickets = generator.generateAutoLottoTickets(1);

        Assertions.assertThat(lottoTickets.getTicketCounts()).isEqualTo(1);
    }

    @DisplayName("원하는 개수만큼 티켓을 생성하는지 확인")
    @Test
    void test() {
        LottoTickets lottoTickets = generator.generateAutoLottoTickets(3);

        Assertions.assertThat(lottoTickets.getTicketCounts()).isEqualTo(3);
    }
}

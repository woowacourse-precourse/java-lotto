package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.constants.LottoConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private static final int purchaseAmount = 8000;
    private static final int countLottoTickets = 8;
    private LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
    private List<Lotto> lottoTickets;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(purchaseAmount);
        lottoTickets = lottoMachine.getLottoTickets();
    }

    @DisplayName("발행할 로또 수량은 로또 한 장의 가격을 나눈 값이다.")
    @Test
    void 로또_수량_테스트() {
        int lottoTicketCount = 8;
        assertThat(lottoMachine.getLottoTicketCount()).isEqualTo(lottoTicketCount);
    }

    @DisplayName("로또의 수량만큼 로또 티켓을 발행한다.")
    @Test
    void 로또_티켓_발행_수량_테스트() {
        assertThat(lottoTickets.size()).isEqualTo(countLottoTickets);
    }

    @DisplayName("발행된 각 로또의 숫자의 개수는 로또 티켓의 크기와 동일하다.")
    @Test
    void 로또_티켓_발행_숫자_갯수_테스트() {
        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(LottoConstants.LOTTO_TICKET_SIZE);

        }
    }

    @DisplayName("발행된 각 로또의 숫자는 중복 없이 생성되어야 한다.")
    @Test
    void 로또_티켓_발행_숫자_중복_테스트() {
        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.getNumbers().stream().allMatch(
                    n -> n >= LottoConstants.LOTTO_NUMBER_MIN && n <= LottoConstants.LOTTO_NUMBER_MAX))
                    .isEqualTo(true);
        }
    }

}
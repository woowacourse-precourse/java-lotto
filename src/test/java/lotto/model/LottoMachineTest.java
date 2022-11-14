package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.constants.LottoConstants;
import lotto.util.constants.WinningScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine();

    @Nested
    @DisplayName("발행할 로또 수량은 로또 한 장의 가격을 나눈 값이다.")
    class CountLottoTicketsTest {
        @Test
        void 로또_수량_테스트_1() {
            assertThat(lottoMachine.computeLottoTicketsCount(8000)).isEqualTo(8);
        }

        @Test
        void 로또_수량_테스트_2() {
            assertThat(lottoMachine.computeLottoTicketsCount(14000)).isEqualTo(14);
        }
    }

    @Nested
    @DisplayName("로또의 수량만큼 로또 티켓을 발행한다.")
    class PublishLottoTicketsTest {
        private static final int countLottoTickets = 8;
        private List<Lotto> lottoTickets;

        @BeforeEach
        void setUp() {
            lottoTickets = lottoMachine.publishLottoTickets(countLottoTickets);
        }

        @Test
        void 로또_티켓_발행_수량_테스트() {
            assertThat(lottoTickets.size()).isEqualTo(countLottoTickets);
        }

        @Test
        void 로또_티켓_발행_숫자_갯수_테스트() {
            for (Lotto lotto : lottoTickets) {
                assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(LottoConstants.LOTTO_TICKET_SIZE);

            }
        }

        @Test
        void 로또_티켓_발행_숫자_중복_테스트() {
            for (Lotto lotto : lottoTickets) {
                assertThat(lotto.getNumbers().stream().allMatch(
                        n -> n >= LottoConstants.LOTTO_NUMBER_MIN && n <= LottoConstants.LOTTO_NUMBER_MAX))
                        .isEqualTo(true);
            }
        }

    }

    @Nested
    @DisplayName("당첨 결과를 계산한다.")
    class ComputeWinningResultsTest {
        private LottoResult lottoResult = new LottoResult();
        private Lotto winningLotto;
        private List<Lotto> userLottoTickets;


        @BeforeEach
        void setUp() {
            winningLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
            userLottoTickets = new ArrayList<>();
            userLottoTickets.add(new Lotto(new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))));
            userLottoTickets.add(new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 14, 22, 45))));
        }

        @Test
        void 일치하는_숫자_갯수_계산_테스트() {
            Lotto userLotto = userLottoTickets.get(1);
            WinningScore winningScore = lottoResult.compareLottoNumber(userLotto.getNumbers(),
                    winningLotto.getNumbers());
            assertThat(winningScore.name()).isEqualTo(WinningScore.THREE.name());
        }
    }

}
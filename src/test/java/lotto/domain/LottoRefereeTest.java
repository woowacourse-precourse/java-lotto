package lotto.domain;

import static lotto.domain.LottoPrize.FIFTH_PRIZE;
import static lotto.domain.LottoPrize.FIRST_PRIZE;
import static lotto.domain.LottoPrize.FOURTH_PRIZE;
import static lotto.domain.LottoPrize.SECOND_PRIZE;
import static lotto.domain.LottoPrize.THIRD_PRIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Buyer;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoReferee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class LottoRefereeTest {
    @Mock
    private LotteryMachine lotteryMachine;
    @Mock
    private Buyer buyer;
    private LottoReferee lottoReferee;

    @BeforeEach
    void initReferee() {
        lottoReferee = new LottoReferee();
        lotteryMachine = mock(LotteryMachine.class);
        buyer = mock(Buyer.class);

        // given
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Lotto firstPrize = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto secondPrize = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto thirdPrize = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lotto fourthPrize = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto fifthPrize = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));

        List<Lotto> lottoTickets = new ArrayList<>(
                Arrays.asList(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize));

        when(lotteryMachine.getWinningLotto()).thenReturn(new Lotto(winningNumbers));
        when(lotteryMachine.getBonusNumber()).thenReturn(bonusNumber);
        when(buyer.getHoldingLottoTickets()).thenReturn(lottoTickets);
    }

    @Test
    @DisplayName("등수 결과 분석이 제대로 되는지 확인한다.")
    void checkAnalyzeFiveTicketsResult() {
        // when
        Map<LottoPrize, Integer> result = lottoReferee.analyzeResult(lotteryMachine, buyer);
        // then
        assertAll(
                () -> assertThat(result.get(FIRST_PRIZE)).isEqualTo(1),
                () -> assertThat(result.get(SECOND_PRIZE)).isEqualTo(1),
                () -> assertThat(result.get(THIRD_PRIZE)).isEqualTo(1),
                () -> assertThat(result.get(FOURTH_PRIZE)).isEqualTo(1),
                () -> assertThat(result.get(FIFTH_PRIZE)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("총 상금이 제대로 계산되는지 확인한다.")
    void checkCalculatePrizes() {
        //given
        lottoReferee.analyzeResult(lotteryMachine, buyer);
        assertThat(lottoReferee.sumPrizes()).isEqualTo(2000000000 + 30000000 + 1500000 + 50000 + 5000);
    }
}
package lotto.domain;

import lotto.Lotto;
import lotto.PrizeNumber;
import lotto.Rank;
import lotto.domain.impl.LottoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static lotto.Constants.COUNT_DEFAULT_VALUE;
import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoServiceImpl();
    private static final PrizeNumber PRIZE_NUMBER = new PrizeNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,FIRST", "1,2,3,4,5,7,SECOND", "1,2,3,4,5,8,THIRD", "1,2,3,4,7,8,FOURTH", "1,2,3,7,8,9,FIFTH"})
    void compare(int number1, int number2, int number3, int number4, int number5, int number6, Rank rank) {
        List<Lotto> issuedLottos = List.of(new Lotto(Arrays.asList(number1, number2, number3, number4, number5, number6)));

        Map<Rank, Integer> results = lottoService.compare(issuedLottos, PRIZE_NUMBER);

        assertThat(results.getOrDefault(rank, COUNT_DEFAULT_VALUE)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 금액이 8000원이고 로또 하나가 5등이라면 수익률은 62.5%이다.")
    void calculateRate() {
        Map<Rank, Integer> results = new HashMap<>() {
            {
                put(FIFTH, 1);
            }
        };

        double rate = lottoService.calculateRate(results, 8000);

        assertThat(rate).isEqualTo(62.5);
    }
}
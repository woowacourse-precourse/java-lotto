package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 이익을_구하는_메서드_확인(int budget, List<Integer> winnings, double answer){
        lottoCalculator = new LottoCalculator(budget);

        assertThat(lottoCalculator.getProfit(winnings)).isEqualTo(answer);
    }

    private static Stream<Arguments> parametersProvider(){
        return Stream.of(
                Arguments.arguments(8000, List.of(1,0,0,0,0,0), 62.5),
                Arguments.arguments(5000, List.of(0,0,1,0,0,0), 30000.0)
        );
    }
}

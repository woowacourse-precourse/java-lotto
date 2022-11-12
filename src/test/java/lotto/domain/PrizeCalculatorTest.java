package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeCalculatorTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 숫자 개수를 구한다")
    void compareLottoAndWinningNumber(Lotto lotto, List<Integer> winningNumber, int result) {
        assertThat(PrizeCalculator.compareWinningNumbers(lotto, winningNumber)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), List.of(7,8,9,10,11,12), 0),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), List.of(7,8,9,10,11,12), 1),
                Arguments.of(new Lotto(List.of(1,2,3,4,7,8)), List.of(7,8,9,10,11,12), 2),
                Arguments.of(new Lotto(List.of(1,2,3,7,8,9)), List.of(7,8,9,10,11,12), 3),
                Arguments.of(new Lotto(List.of(1,2,7,8,9,10)), List.of(7,8,9,10,11,12), 4),
                Arguments.of(new Lotto(List.of(1,7,8,9,10,11)), List.of(7,8,9,10,11,12), 5),
                Arguments.of(new Lotto(List.of(7,8,9,10,11,12)), List.of(7,8,9,10,11,12), 6)
        );
    }

    @DisplayName("일치하는 숫자 개수와 보너스 숫자 일치 여부가 주어지면 그에 맞는 상금을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "0,false,0",
            "1,false,0",
            "2,false,0",
            "3,false,5000",
            "4,false,50000",
            "5,false,1_500_000",
            "5,true,30_000_000",
            "6,false,2_000_000_000"
    })
    void returnMatchingPrize(int matchingNumber, boolean bonus, long prizeAmount){
        assertThat(PrizeCalculator.getPrizeAmount(matchingNumber, bonus)).isEqualTo(prizeAmount);
    }
}

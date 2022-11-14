package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    private static Stream<Arguments> provideUserLottosAndAnswer() {
        return Stream.of(
                Arguments.of(List.of(),0),
                Arguments.of(List.of(Rank.from(5)),5_000),
                Arguments.of(List.of(Rank.from(4)),50_000),
                Arguments.of(List.of(Rank.from(3)),1_500_000),
                Arguments.of(List.of(Rank.from(2)),30_000_000),
                Arguments.of(List.of(Rank.from(1)),2_000_000_000),
                Arguments.of(List.of(Rank.from(1),Rank.from(1),Rank.from(1),Rank.from(1)),8_000_000_000L)
        );
    }

    @ParameterizedTest
    @DisplayName("로또를 통해 발생한 수익을 계산한다.")
    @MethodSource("provideUserLottosAndAnswer")
    void countContainedLottoNumbers(List<Rank> resultList, long answer) {
        //given
        Result statics = Result.of(resultList);
        //when
        long profits = statics.calculateProfit();
        //then
        Assertions.assertThat(profits).isEqualTo(answer);
    }
}

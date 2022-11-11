package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @ParameterizedTest(name = "로또 {1} Place 당첨")
    @MethodSource("lottoResultAndPrize")
    void CompareResult가_몇등_당첨인지_판단하는_기능(CompareResult lottoResult, Prize prize) {
        assertThat(Prize.toPrize(lottoResult)).isEqualTo(prize);
    }

    static Stream<Arguments> lottoResultAndPrize() {
        return Stream.of(
            Arguments.of(new CompareResult(6, false), Prize.FIRST)
                , Arguments.of(new CompareResult(5, true), Prize.SECOND)
                , Arguments.of(new CompareResult(5, false), Prize.THIRD)
                , Arguments.of(new CompareResult(4, true), Prize.FOURTH)
                , Arguments.of(new CompareResult(4, false), Prize.FOURTH)
                , Arguments.of(new CompareResult(3, true), Prize.FIFTH)
                , Arguments.of(new CompareResult(3, false), Prize.FIFTH)
                , Arguments.of(new CompareResult(2, true), Prize.NO_PRIZE)
        );
    }
}
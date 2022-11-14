package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @ParameterizedTest(name = "로또 {1} Place 당첨")
    @MethodSource("lottoResultAndPrize")
    void CompareResult가_몇등_당첨인지_판단하는_기능(CompareResult lottoResult, LottoPrize lottoPrize) {
        assertThat(LottoPrize.toPrize(lottoResult)).isEqualTo(lottoPrize);
    }

    @ParameterizedTest(name = "{0} 당첨 상금 {1}원")
    @CsvSource({"FIRST,2_000_000_000", "SECOND,30_000_000", "THIRD,1_500_000", "FOURTH,50_000", "FIFTH,5_000"})
    void 당첨_상금_반환_기능(String prize, int moneyAmount) {
        assertThat(LottoPrize.valueOf(prize).getMoney()).isEqualTo(moneyAmount);
    }

    static Stream<Arguments> lottoResultAndPrize() {

        return Stream.of(
                Arguments.of(new CompareResult(6, false), LottoPrize.FIRST)
                , Arguments.of(new CompareResult(5, true), LottoPrize.SECOND)
                , Arguments.of(new CompareResult(5, false), LottoPrize.THIRD)
                , Arguments.of(new CompareResult(4, true), LottoPrize.FOURTH)
                , Arguments.of(new CompareResult(4, false), LottoPrize.FOURTH)
                , Arguments.of(new CompareResult(3, true), LottoPrize.FIFTH)
                , Arguments.of(new CompareResult(3, false), LottoPrize.FIFTH)
                , Arguments.of(new CompareResult(2, true), LottoPrize.NO_PRIZE)
        );
    }
}
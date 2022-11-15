package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoResultTest {

    @Test
    void getCount_메서드는_LottoPrize에_대한_값이_있다면_해당_값을_반환한다() {
        Map<LottoPrize, Long> lottoPrizeToInteger = Map.of(_1ST_PRIZE, 3L);
        LottoResult lottoResult = new LottoResult(lottoPrizeToInteger);

        assertThat(lottoResult.getCount(_1ST_PRIZE)).isEqualTo(3);
    }

    @Test
    void getCount_메서드는_LottoPrize에_대한_값이_없다면_0을_반환한다() {
        Map<LottoPrize, Long> lottoPrizeToInteger = Map.of(_1ST_PRIZE, 1L);
        LottoResult lottoResult = new LottoResult(lottoPrizeToInteger);

        assertThat(lottoResult.getCount(_2ND_PRIZE)).isEqualTo(0);
    }

    @ParameterizedTest(name = "당첨결과가{0}인 경우 이익률은{1}%이다.")
    @MethodSource("lottoResultAndProfitRatio")
    void calculateProfitRatio_메서드는_당첨_결과에_대한_구매금액_대비_이익률을_반환한다(
            Map<LottoPrize, Long> lottoPrizeToCount,
            double profitRatio
    ) {
        LottoResult lottoResult = new LottoResult(lottoPrizeToCount);
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(profitRatio);
    }

    static List<Arguments> lottoResultAndProfitRatio() {
        return Arrays.asList(
                Arguments.of(Map.of(_1ST_PRIZE, 1L, _5TH_PRIZE, 5L, _NOTHING, 4L), 20000250.0),
                Arguments.of(Map.of(_2ND_PRIZE, 1L, _4TH_PRIZE, 2L, _NOTHING, 7L), 301000.0),
                Arguments.of(Map.of(_3RD_PRIZE, 1L, _NOTHING, 9L), 15000.0),
                Arguments.of(Map.of(_4TH_PRIZE, 1L, _5TH_PRIZE, 2L, _NOTHING, 22L), 240.0),
                Arguments.of(Map.of(_5TH_PRIZE, 1L, _NOTHING, 7L), 62.5),
                Arguments.of(Map.of(_5TH_PRIZE, 1L, _NOTHING, 499L), 1.0),
                Arguments.of(Map.of(_5TH_PRIZE, 2L, _NOTHING, 1L), 10000L / 3000.0 * 100),
                Arguments.of(Map.of(_3RD_PRIZE, 1L), 150000.0),
                Arguments.of(Map.of(_NOTHING, 3L), 0.0),
                Arguments.of(Map.of(), 0.0)
        );
    }

    @Test
    void value_메서드는_당첨_결과의_EnumMap을_반환한다() {
        LottoResult lottoResult = new LottoResult(Map.of(_4TH_PRIZE, 1L, _5TH_PRIZE, 2L));
        EnumMap<LottoPrize, Long> result = lottoResult.value();

        assertThat(result.get(_4TH_PRIZE)).isEqualTo(1L);
        assertThat(result.get(_5TH_PRIZE)).isEqualTo(2L);
    }
}

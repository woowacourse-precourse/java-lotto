package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoResultTest {

    @Test
    void getCount_메서드는_LottoPrize에_대한_값이_있다면_해당_값을_반환한다() {
        Map<LottoPrize, Long> lottoPrizeToInteger = Map.of(_1ST_PRIZE, 3L);
        LottoResult lottoResult = new LottoResult(lottoPrizeToInteger);

        Assertions.assertThat(lottoResult.getCount(_1ST_PRIZE)).isEqualTo(3);
    }

    @Test
    void getCount_메서드는_LottoPrize에_대한_값이_없다면_0을_반환한다() {
        Map<LottoPrize, Long> lottoPrizeToInteger = Map.of(_1ST_PRIZE, 1L);
        LottoResult lottoResult = new LottoResult(lottoPrizeToInteger);

        Assertions.assertThat(lottoResult.getCount(_2ND_PRIZE)).isEqualTo(0);
    }
}

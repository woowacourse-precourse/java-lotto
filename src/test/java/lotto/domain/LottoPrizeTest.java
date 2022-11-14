package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static lotto.domain.LottoPrize.getEnum;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoPrize 이늄")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoPrizeTest {

    @ParameterizedTest(name = "{0}개를 맞추고 보너스 맞춤 여부가 {1}일 경우 {2}를 반환한다")
    @MethodSource("matchedInformation")
    void getEnum_메서드는_맞춘개수를_입력받아_LottoPrize를_반환한다(int matched, boolean bonusMatched, LottoPrize result) {
        assertThat(getEnum(matched, bonusMatched)).isEqualTo(result);
    }

    static List<Arguments> matchedInformation() {
        return Arrays.asList(
                Arguments.of(6, true, _1ST_PRIZE),
                Arguments.of(6, false, _1ST_PRIZE),
                Arguments.of(5, true, _2ND_PRIZE),
                Arguments.of(5, false, _3RD_PRIZE),
                Arguments.of(4, true, _4TH_PRIZE),
                Arguments.of(4, false, _4TH_PRIZE),
                Arguments.of(3, true, _5TH_PRIZE),
                Arguments.of(3, false, _5TH_PRIZE),
                Arguments.of(2, false, _NOTHING)
        );
    }

    @Test
    void calculatePrize_메서드는_맞춘개수를_입력받아_당첨금의_합을_반환한다() {
        LottoPrize lottoPrize = _1ST_PRIZE;
        assertThat(lottoPrize.calculatePrize(2L)).isEqualTo(lottoPrize.getPrize() * 2L);
    }

    @ParameterizedTest
    @CsvSource({"_1ST_PRIZE, 6", "_2ND_PRIZE, 5", "_3RD_PRIZE, 5", "_4TH_PRIZE, 4", "_5TH_PRIZE, 3"})
    void getMatchCount_메서드는_해당_당첨금을_얻기위해_맞춰야하는_숫자의_개수를_반환한다(LottoPrize lottoPrize, Integer count) {
        assertThat(lottoPrize.getMatchCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource({
            "_1ST_PRIZE, 2_000_000_000",
            "_2ND_PRIZE, 30_000_000",
            "_3RD_PRIZE, 1_500_000",
            "_4TH_PRIZE, 50_000",
            "_5TH_PRIZE, 5_000"
    })
    void getPrize_메서드는_Enum의_당첨금을_반환한다(LottoPrize lottoPrize, Long prize) {
        assertThat(lottoPrize.getPrize()).isEqualTo(prize);
    }
}

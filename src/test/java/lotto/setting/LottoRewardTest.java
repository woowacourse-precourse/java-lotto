package lotto.setting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class LottoRewardTest {

    @DisplayName("getRewardInfoTest")
    @ParameterizedTest(name = "{displayName} Case {index}")
    @ArgumentsSource(RewardInfoTestData.class)
    void getRewardInfoTest(LottoReward lottoReward, String expected) {
        String result = lottoReward.getRewardInfo();

        assertThat(result).isEqualTo(expected);
    }

    static class RewardInfoTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(LottoReward.FIRST, "6개 일치 (2,000,000,000원)"),
                    Arguments.of(LottoReward.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                    Arguments.of(LottoReward.THIRD, "5개 일치 (1,500,000원)"),
                    Arguments.of(LottoReward.FOURTH, "4개 일치 (50,000원)"),
                    Arguments.of(LottoReward.FIFTH, "3개 일치 (5,000원)")
            );
        }
    }
}

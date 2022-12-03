package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class WinningInformationTest {
    static class GetYieldSourceProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    //당첨 정보, 구입한 로또 개수, 예상 반환 결과를 공금한다.
                    Arguments.of(Collections.emptyList(), 1, 0.0),
                    Arguments.of(List.of(Winning.THREE), 8, 62.5),
                    Arguments.of(List.of(Winning.THREE), 5, 100.0),
                    Arguments.of(List.of(Winning.SIX), 2, 1.0E+8)
            );
        }
    }

    @Nested
    @DisplayName("getYield 메서드는")
    class DescribeGetYield {
        @ParameterizedTest
        @ArgumentsSource(GetYieldSourceProvider.class)
        @DisplayName("호출되면 당첨금과 구입 금액간의 수익률을 반환한다.")
        void willReturnYield(List<Winning> winnings, int count, double expect) {
            WinningInformation winningInformation = new WinningInformation(winnings);

            double actual = winningInformation.getYield(count);

            Assertions.assertThat(actual).isEqualTo(expect);
        }
    }
}
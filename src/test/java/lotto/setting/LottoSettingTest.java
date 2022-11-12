package lotto.setting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

public class LottoSettingTest {

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(ValidTestData.class)
    void validTest(List<Integer> numbers, boolean expected, String testMessage) {
        LottoSetting lottoSetting = LottoSetting.NORMAL;

        boolean result = lottoSetting.isValidNumbers(numbers);

        assertThat(result).isEqualTo(expected);
    }

    static class ValidTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of(4,8,12,16,20,24), true, "true case 1"),
                    Arguments.of(List.of(5,9,12,13,44,45), true, "true case 1"),
                    Arguments.of(List.of(5,5,12,13,14,15), false, "false case, Overlapped"),
                    Arguments.of(List.of(1,2,3), false, "false case, list size not matched"),
                    Arguments.of(List.of(1,2,3,4,5,55), false, "false case, over max number")
            );
        }
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PreprocessorTest {
    @DisplayName("숫자에다가 구두점 찍기")
    @ParameterizedTest(name = "{index}. before = {0}, after = {1}")
    @CsvSource({"5_000,'5,000'", "30_000_000,'30,000,000'", "2_000_000_000, '2,000,000,000'"})
    void createNumberPunctuation(int prizeMoney, String result) {
        assertThat(Preprocessor.addNumberPunctuation(prizeMoney)).isEqualTo(result);
    }

    @DisplayName("반올림하여 n번째 자리까지 나타내기")
    @ParameterizedTest(name = "{index}. before = {0}, n = {1}, after = {2}")
    @CsvSource({"12.345, 2, 12.35", "100.0, 1, 100.0", "95.733, 1, 95.7"})
    void createRoundedNumber(double before, int decimalPlace, String after) {
        assertThat(Preprocessor.getRoundDecimalPlaceNumber(before, decimalPlace))
                .isEqualTo(after);
    }
}
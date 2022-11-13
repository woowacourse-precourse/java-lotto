package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GuideTest {
    @DisplayName("숫자에다가 구두점 찍기")
    @ParameterizedTest(name = "{index}. before = {0}, after = {1}")
    @CsvSource({"5_000,'5,000'","30_000_000,'30,000,000'","2_000_000_000, '2,000,000,000'"})
    void createNumberPunctuation(int prizeMoney, String result) {
        assertThat(Guide.addNumberPunctuation(prizeMoney)).isEqualTo(result);
    }
}
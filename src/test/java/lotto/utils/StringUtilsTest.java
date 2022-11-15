package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @DisplayName("Null or Empty 인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void isNullOrEmpty(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }
}
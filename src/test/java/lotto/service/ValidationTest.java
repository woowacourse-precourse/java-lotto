package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.service.Validation.*;

class ValidationTest {

    @ParameterizedTest
    @DisplayName("범위 검증 테스트")
    @CsvSource(
            value = {
                    "1:2:3",
                    "1:1:1",
                    "1:2:2"
            }, delimiter = ':'
    )
    void test1(final int lower, final double x, final int upper) {
        assert isInRange(lower, x, upper);
    }


}
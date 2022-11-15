package util;

import domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringUtilTest {
    @ParameterizedTest
    @DisplayName("형 변환 실패")
    @ValueSource(strings = {"a" , "bc", "2da", "32h"})
    void FormattingFailed(String input){
        assertThatThrownBy(() -> StringUtil.parseToInt(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
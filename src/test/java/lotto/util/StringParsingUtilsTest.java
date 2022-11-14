package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringParsingUtilsTest {
    @Test
    @DisplayName("리스트로 변환된 로또 크기가 로또 사이즈와 같다면 성공이다.")
    void isParsedListSizeEqualToLottoSize() {
        int LOTTO_SIZE = 6;
        String testInput = "1,2,3,4,5,6";

        assertThat(StringParsingUtils.parseToNumber(testInput).size()).isEqualTo(LOTTO_SIZE);
    }
}
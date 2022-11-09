package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertLottoCountTest {

    @DisplayName("구매 금액을 로또 개수로 변환하는 테스트")
    @Test
    void getLottoCount() {
        int lottoCount = ConvertLottoCount.get(1000);
        assertAll(
                () -> assertEquals(1, lottoCount),
                () -> assertNotEquals(2, lottoCount)
        );
    }
}
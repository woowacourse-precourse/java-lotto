package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {


    @Test
    @DisplayName("LottoMoney 유효성 검증 살패 테스트")
    void validateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoMoney("1111"));
    }

    @Test
    @DisplayName("LottoMoney 생성 성공 테스트")
    void createLottoMoneyTest() {
        Assertions.assertDoesNotThrow(() -> new LottoMoney("8000"));
    }

}
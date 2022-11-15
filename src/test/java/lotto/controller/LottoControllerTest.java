package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
    
    @DisplayName("수익률 계산이 맞는지")
    @Test
    void 수익_계산_테스트() {
        String result = LottoController.calculateProfitRate(5500,10000);
        Assertions.assertThat(result).isEqualTo("55.0");
    }
}

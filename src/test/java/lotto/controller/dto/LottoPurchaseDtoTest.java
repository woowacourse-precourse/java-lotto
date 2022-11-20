package lotto.controller.dto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseDtoTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4"}, delimiter = ':')
    @DisplayName("로또 구매비용 입력시 몇개의 로또가 구매되는지 테스트")
    void getLottos(int money, int count) {
        LottoPurchaseDto lottoPurchaseDto = new LottoPurchaseDto(money);
        assertThat(lottoPurchaseDto.getLottos().size()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1010, 1100, 999, 100})
    @DisplayName("로또 비용이 1000으로 나눠떨어지지 않을경우 예외처리")
    void lottosException(int money) {
        assertThatThrownBy(() -> new LottoPurchaseDto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

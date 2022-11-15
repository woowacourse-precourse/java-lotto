package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputServiceTest {

    private final InputService inputService = new InputService();

    @Test
    @DisplayName("당첨 번호 입력 형식에 맞지 않으면 예외가 발생한다.")
    void validateWinningNumbersFormat() {
        // given
        List<String> invalidInputList = List.of("1,2,,3,4,5", "1", "1,2,$3,4,6,7", "가,나,3,4,5,6",
            " , , , , , ");

        // then
        invalidInputList.forEach(input -> {
            assertThatThrownBy(() -> inputService.validateWinningNumbersFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("정해진 단위가 아닌 구입 금액은 예외가 발생한다.")
    void validatePurchaseAmount() {
        // given
        int purchaseAmount = 8200;

        // then
        assertThatThrownBy(() -> inputService.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수가 아닌 입력은 예외가 발생한다.")
    void getInteger() {
        // given
        List<String> InvalidInputList = List.of("1000원", "200000000000", "2.001");

        // then
        InvalidInputList.forEach(input -> {
            assertThatThrownBy(() -> InputService.getInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
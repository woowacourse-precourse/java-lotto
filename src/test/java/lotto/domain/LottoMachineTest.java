package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.LottoSetting.LOTTO_PRICE;
import static lotto.exception.LottoMachineExceptionMessage.MACHINE_NOT_ENOUGH_CASH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoMachineTest {
    @ParameterizedTest(name = "[{index}] cashAmount = {0}")
    @MethodSource("whenPurchaseLottosThenSuccessDummy")
    @DisplayName("현금을 이용한 로또 구매 성공 테스트")
    void whenPurchaseLottosThenSuccessTest(int cashAmount) {
        LottoMachine lottoMachine = new LottoMachine(new Cash(cashAmount));
        Lottos lottos = lottoMachine.purchaseLottos();
        int lottosCount = lottos.getLottos().size();
        int purchasableCount = cashAmount / LOTTO_PRICE.getSetting();
        assertThat(lottosCount).isEqualTo(purchasableCount);
    }

    @Test
    @DisplayName("현금 부족으로 인한 로또 구매 예외처리 테스트")
    void whenPurchaseLottosNotEnoughCashThenSuccessTest() {
        LottoMachine lottoMachine = new LottoMachine(new Cash(0));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(lottoMachine::purchaseLottos)
                .withMessage(MACHINE_NOT_ENOUGH_CASH.getMessage());
    }

    static Stream<Arguments> whenPurchaseLottosThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(1000),
                Arguments.arguments(2000),
                Arguments.arguments(3000),
                Arguments.arguments(10000),
                Arguments.arguments(11000),
                Arguments.arguments(12000),
                Arguments.arguments(13000),
                Arguments.arguments(110000),
                Arguments.arguments(120000),
                Arguments.arguments(130000),
                Arguments.arguments(112345000)
        );
    }
}
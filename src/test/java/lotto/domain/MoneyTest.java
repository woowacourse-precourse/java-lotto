package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.errorenum.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    private static final int MIN_AMOUNT = 1000;
    private static final String MIN_MONEY_LIMIT = String.format("%d원 이상 구매해야 합니다.", MIN_AMOUNT);
    private static final String MONEY_CHANGE_LEFT = String.format("잔돈이 발생하였습니다. %d원 단위로 입력해주세요.", MIN_AMOUNT);

    @DisplayName("로또 구입 금액이 최소 금액 (1000원) 이하면 오류가 발생한다")
    @Test
    void createMoneyInputWithLimitError() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.printError(MIN_MONEY_LIMIT));
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않는다면 오류가 발생한다")
    @Test
    void createMoneyInputWithChangeLeft() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.printError(MONEY_CHANGE_LEFT));
    }

}

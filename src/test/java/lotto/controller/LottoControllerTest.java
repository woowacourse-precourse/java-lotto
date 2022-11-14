package lotto.controller;

import lotto.ApplicationContext;
import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.MoneyValidator;
import lotto.controller.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private LottoController controller;

    @BeforeEach
    void init() {
        controller = ApplicationContext.getContext().getController();
    }

    @DisplayName("로또 구입 금액이 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidMoney() {
        assertAll(
                () -> assertThatThrownBy(() -> controller.inputMoney("non digit"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoneyValidator.IS_NATURAL_NUMBER.getErrorMessage()),

                () -> assertThatThrownBy(() -> controller.inputMoney("100000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoneyValidator.IS_IN_BOUNDS.getErrorMessage()),

                () -> assertThat(MoneyValidator.IS_PARSEABLE.getPredicate().test("non digit"))
                        .isFalse()
        );
    }

    @DisplayName("당첨 번호가 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidWinningNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> controller.inputWinningNumber("1 2 3 4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WinningNumberValidator.IS_SEPERATED_BY_COMMA.getErrorMessage()),

                () -> assertThatThrownBy(() -> controller.inputWinningNumber("f,d,f,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]")
        );
    }

    @DisplayName("보너스 번호가 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidBonusNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> controller.inputBonusNumber("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BonusNumberValidator.IS_NATURAL_NUMBER.getErrorMessage()),

                () -> assertThatThrownBy(() -> controller.inputBonusNumber("47"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BonusNumberValidator.IS_IN_BOUNDS.getErrorMessage())
                );
    }
}

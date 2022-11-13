package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewValidatorValidatorTest {
    private InputViewValidator inputViewValidator;

    @BeforeEach
    void setUp() {
        this.inputViewValidator = new InputViewValidator();
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 경우 에러를 반환한다.")
    @Test
    void inputPurchaseMoneyNotDivideThousand() {
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> inputViewValidator.validateDivideThousand(2000)),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(1300))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(100))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    void 구입_금액이_1000으로_나누어_떨어지지_않을_경우_예외가_발생한다(){
        int input = 2500;
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }


}

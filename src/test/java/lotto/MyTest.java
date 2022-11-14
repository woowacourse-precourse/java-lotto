package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    void 구입_금액이_1000으로_나누어_떨어지지_않을_경우_예외가_발생한다() {
        List<Integer> testNumbers = Arrays.asList(2500, 145, 1, 4556, -1000);
        InputValidator inputValidator = new InputValidator();
        for (Integer testNumber : testNumbers) {
            assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(testNumber)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호는 1에서 45사이의 숫자만 가져야 한다.")
    void 로또_번호는_1에서_45사이의_숫자만_가져야_한다(){
        List<Integer> testNumbers = Arrays.asList(0, 46, 100, 55, -100);
        InputValidator inputValidator = new InputValidator();
        for (Integer testNumber : testNumbers) {
            assertThatThrownBy(() -> inputValidator.validateLottoNumber(testNumber)).isInstanceOf(IllegalArgumentException.class);
        }
    }


}

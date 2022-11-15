package lotto.model.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.vallidator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 숫자가 6개가 아니면 예외가 발생한다.")
    @Test
    void lottoNumbersOverSize() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 1~45 범위를 벗어난 경우 예외가 발생한다.")
    @Test
    void lottoNumbersNotInRange() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 모두 다르지 않은 경우 예외가 발생한다.")
    @Test
    void lottoNumbersDuplicate() {
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1~45 범위를 벗어난 경우 예외가 발생한다.")
    @Test
    void bonusNumbersNotInRange() {
        assertThatThrownBy(() -> LottoValidator.validate(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 로또 번호에 포함된 경우 예외가 발생한다.")
    @Test
    void bonusNumbersDuplicate() {
        assertThatThrownBy(() -> LottoValidator.validate(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
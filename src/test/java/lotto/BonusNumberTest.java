package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되거나 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 46})
    void createWrongBonusNumberInput(int bonusNumber) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() ->
                BonusNumber.validate(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

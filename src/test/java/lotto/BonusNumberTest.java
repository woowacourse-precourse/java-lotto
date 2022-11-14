package lotto;

import lotto.numbers.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

  @DisplayName("들어온 보너스 넘버가 숫자로만 이루어져 있는지 테스트")
  @Test
  void isOnlyDigitBonusNumber() {
    assertThatThrownBy(() -> BonusNumber.isOnlyDigitBonusNumber("1a4"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("들어온 보너스 넘버가 범위에 포함되는지 테스트")
  @Test
  void isInRangeBonusNumber() {
    assertThatThrownBy(() -> BonusNumber.isInRangeBonusNumber("400"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void validBonusNumber() {
  }
}
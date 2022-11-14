package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

  @DisplayName("당첨 번호와 같지 않은 보너스 넘버 판별")
  @Test
  void validBonusNumber() {
    assertThat(BonusNumber.validBonusNumber("2", List.of(1,5,6,8,34,4)))
            .isEqualTo(2);
    assertThatThrownBy(() -> BonusNumber.validBonusNumber("2", List.of(2,4,1,8,9)))
            .isInstanceOf(IllegalArgumentException.class);
  }
}
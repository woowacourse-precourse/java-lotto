package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

  @DisplayName("들어온 String type의 Money가 숫자로만 이루어져 있는지 검사")
  @Test
  void isOnlyDigitsMoney() {
    assertThatThrownBy(() -> Money.checkMoneyIsDigit("12a4"))
            .isInstanceOf(IllegalArgumentException.class);

  }

  @Test
  void percentage() {
  }
}
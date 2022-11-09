package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

  @DisplayName("입력한 값이 숫자가 아니라면 예외가 발생한다")
  @Test
  void checkMoneyIsDigit() {
    assertThatThrownBy(() -> new Money().checkMoneyIsDigit("a243"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력한 값이 1000원단위로 끊어지지 않는다면 예외가 발생한다")
  @Test
  void checkDividableMoney() {
  }

  @Test
  void isValidMoney() {

  }
}
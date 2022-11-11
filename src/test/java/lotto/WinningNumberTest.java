package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

  @DisplayName("들어온 String이 범위 내에 포함되어있지 않을 경")
  @Test
  void notRangeNumber() {
    assertThatThrownBy(() -> new WinningNumber().splitNumber("152,3,4"))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new WinningNumber().isNumberInRange(46))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("들어온 String이 숫자 외의 것이 포함되어 있을 경우")
  @Test
  void notOnlyDigitNumber() {
    assertThatThrownBy(() -> new WinningNumber().splitNumber("a,25,24"))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new WinningNumber().splitNumber("24 2 26"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}
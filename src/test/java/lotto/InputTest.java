package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

  @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 Exception처리")
  @Test
  void divideBy1000Validate() {
    Input input = new Input();
    assertThatThrownBy(() -> input.validate(8500))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사용자가 입력한 로또번호를 \",\"를 기준으로 분리한다.")
  @Test
  void separateByComma() {
    String inputLottoNumber = "1,2,3,4,5,6";
    assertThat(inputLottoNumber.split(","))
        .containsExactly("1", "2", "3", "4", "5", "6");
  }
}
package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputMoneyTest {
  @DisplayName("입력 금액에 문자가 있으면 예외가 발생한다.")
  @Test
  void createInputMoneyAlphabet() {
    String money = "1000kd";

    assertThatThrownBy(() -> new InputMoney(money))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력 금액이 1000단위가 아니면 예외가 발생한다.")
  @Test
  void createInputMoneyRest() {
    String money = "10007";

    assertThatThrownBy(() -> new InputMoney(money))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("성공테스트")
  @Test
  void createInputMoney() {
    String money = "10000";
    int lottoTicket = 10;

    InputMoney usedMoney = new InputMoney(money);

    assertThat(usedMoney.getAbleCount()).isEqualTo(lottoTicket);
  }


}
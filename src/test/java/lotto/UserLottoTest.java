package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottoTest {
  @DisplayName("입력금액이 없을 시 예외가 발생한다")
  @Test
  void createNullMoneyCheck(){
    assertThatThrownBy(() -> new UserLotto(""))
        .isInstanceOf(IllegalArgumentException.class);
  }
  @DisplayName("입력금액이 숫자가 아닐 시 예외가 발생한다.")
  @Test
  void createMoneyStringCheck(){
    assertThatThrownBy(() -> new UserLotto("aaaa"))
        .isInstanceOf(NoSuchElementException.class);
  }
  @DisplayName("입력금액이 1,000원 단위가 아닐 시 예외가 발생한다")
  @Test
  void createMoneyUnit(){
    assertThatThrownBy(() -> new UserLotto("999"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

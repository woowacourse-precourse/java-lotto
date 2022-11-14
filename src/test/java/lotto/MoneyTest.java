package lotto;

import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

  @DisplayName("들어온 String type의 Money가 숫자로만 이루어져 있는지 검사")
  @Test
  void isOnlyDigitsMoney() {
    String notDigit = "12a4";
    assertThatThrownBy(() -> Money.checkMoneyIsDigit(notDigit))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("1000원 단위로 나누어지는지 검사")
  @Test
  void isDividableNumber() {
    String test1 = "1400";
    String test2 = "300";
    String test3 = "1000";
    String test4 = "140000";
    assertThatThrownBy(() -> Money.countLotto(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Money.countLotto(test2))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Money.countLotto(test3)) // 통과 케이스
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Money.countLotto(test4))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("카운트 된 로또의 개수 검사")
  @Test
  void lottoCount_test() {
    Money.countLotto("4000");
    assertThat(Money.count).isEqualTo(4);
    Money.countLotto("120000");
    assertThat(Money.count).isEqualTo(120);;
  }
}
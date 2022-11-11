//package lotto;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class MoneyTest {
//
//  @DisplayName("입력한 값이 숫자가 아니라면 예외가 발생한다")
//  @Test
//  void checkMoneyIsDigit() {
//    assertThatThrownBy(() -> new Money().checkMoneyIsDigit("a243"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//
//  @DisplayName("입력한 값이 1000원단위로 끊어지지 않는다면 예외가 발생한다")
//  @Test
//  void checkDividableMoney() {
//    assertThatThrownBy(() -> new Money().checkDividableMoney("1234"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//
//  @DisplayName("1000원 단위로 끊어지지 않거나, 숫자가 아닌 경우 예외가 발생한다")
//  @Test
//  void countLotto() {
//    assertThatThrownBy(() -> new Money().countLotto("1a00"))
//            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> new Money().countLotto("1340"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//}
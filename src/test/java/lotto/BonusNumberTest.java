//package lotto;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class BonusNumberTest {
//
//  @DisplayName("하나 이상의 숫자가 들어올 경우")
//  @Test
//  void overCountNumber() {
//    BonusNumber bonusNumber = new BonusNumber();
//    assertThatThrownBy(() -> bonusNumber.isValidBonusNumber("1,2,3"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//
//  @DisplayName("숫자 이외의 것이 들어올 경우")
//  @Test
//  void notOnlyDigit() {
//    BonusNumber bonusNumber = new BonusNumber();
//    assertThatThrownBy(() -> bonusNumber.isValidBonusNumber("1a"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//
//  @DisplayName("1 ~ 45 범위 내에 포함되지 않을 경우")
//  @Test
//  void isValidBonusNumber() {
//    BonusNumber bonusNumber = new BonusNumber();
//    assertThatThrownBy(() -> bonusNumber.isValidBonusNumber("46"))
//            .isInstanceOf(IllegalArgumentException.class);
//  }
//}
package lotto;

import lotto.domain.WinningNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

  @DisplayName("당첨번호 중 중복된 숫자가 있으면 예외 발생")
  @Test
  void redundantWinningNumbers() {
    List<Integer> test1 = List.of(1,1,3,4,5);
    assertThatThrownBy(() -> WinningNumber.isDuplicateWinningNumber(test1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨번호가 6자리가 아니라면 예외 발생")
  @Test
  void overOrUnderSizeWinningNumbers() {
    List<Integer> test1 = List.of(1,2,3,4,5);
    List<Integer> test2 = List.of(1,2,3,4,5,6,7);
    assertThatThrownBy(() -> WinningNumber.sizeIsSix(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> WinningNumber.sizeIsSix(test2))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("유효한 숫자들이 integer List로 반환되는지 테스트")
  @Test
  void stringToList() {
    String test1 = "1,2,3,4,5,6";
    List<Integer> integers = List.of(1,2,3,4,5,6);
    WinningNumber winningNumber = new WinningNumber(test1);

    assertThat(winningNumber.validWinningNumber(test1)).isEqualTo(integers);
  }
}

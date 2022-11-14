package lotto;

import lotto.domain.WinningNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

  @DisplayName("당첨번호 중 중복된 숫자가 있으면 예외처리")
  @Test
  void duplicate_number() {
    List<Integer> test1 = List.of(1,1,3,4,5);
    assertThatThrownBy(() -> WinningNumber.isDuplicateWinningNumber(test1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 당첨번호_자릿수_검사_테스트() {
    List<Integer> test1 = List.of(1,2,3,4,5);
    List<Integer> test2 = List.of(1,2,3,4,5,6,7);
    assertThatThrownBy(() -> WinningNumber.sizeIsSix(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> WinningNumber.sizeIsSix(test2))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 유효한_숫자_테스트() {
    String test1 = "1,2,3,4,5,6";
    List<Integer> integers = List.of(1,2,3,4,5,6);
    WinningNumber winningNumber = new WinningNumber(test1);

    assertThat(winningNumber.validWinningNumber(test1)).isEqualTo(integers);
  }
}

package lotto;

import lotto.numbers.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
}

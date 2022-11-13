package lotto;

import lotto.numbers.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
  void 여섯자리_당첨번호_테스트() {
    List<Integer> test1 = List.of(1,1,3,4,5);
    assertThatThrownBy(() -> WinningNumber.sizeIsSix(test1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 유효한_숫자_테스트() {
    String test1 = "1,2,3,4,5,6,7";
    WinningNumber winningNumber = new WinningNumber(test1);

    assertThatThrownBy(() -> winningNumber.validWinningNumber(test1))
            .isInstanceOf(IllegalArgumentException.class);
  }
}

package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckTest {

  @DisplayName("로또 번호가 몇개 당첨됬는지 확인한다.")
  @Test
  void correctNumbers() {
    Check check = new Check();
    int result = check.correctNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("보너스번호가 당첨되는지 확인한다.")
  @Test
  void correctBonus() {
    Check check = new Check();
    boolean result = check.correctBonus(List.of(1, 2, 3, 4, 5, 6), 6);
    assertThat(result).isEqualTo(true);
  }
}
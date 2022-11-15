package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusTest {

  @DisplayName("보너스 번호가 로또 번호에 들어있으면 예외가 발생한다.")
  @Test
  void createDuplicatedBonusNumberOfLotto() {
    assertThatThrownBy(() -> new LottoBonus(6, List.of(1, 2, 3, 4, 5, 6)))
        .isInstanceOf(IllegalArgumentException.class);
  }
  @DisplayName("보너스 번호가 45를 넘으면 예외가 발생한다.")
  @Test
  void createBonusNumberByOverSize() {
    assertThatThrownBy(() -> new LottoBonus(46, List.of(1, 2, 3, 4, 5, 6)))
        .isInstanceOf(IllegalArgumentException.class);
  }
  @DisplayName("보너스 번호가 1보다 작다면 예외가 발생한다.")
  @Test
  void createBonusNumberByUnderSize(){
    assertThatThrownBy(() -> new LottoBonus(0, List.of(1,2,3,4,5,6)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

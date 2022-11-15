package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTypeTest {

  private final List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
  private final int bonusNumber = 7;
  private List<Integer> userNumber;

  @Test
  @DisplayName("6개 번호 맞음")
  void 여섯개의_번호가_맞는_경우() {
    userNumber = List.of(1, 2, 3, 4, 5, 6);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.SIX_SAME, lottoType);
    assertEquals(2000000000, lottoType.getMoney());
  }

  @Test
  @DisplayName("5개 번호 + 보너스 번호 맞음")
  void 다섯개의_번호와_보너스번호가_맞는_경우() {
    userNumber = List.of(1, 2, 3, 4, 5, 7);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.FIVE_SAME_AND_BONUS, lottoType);
    assertTrue(lottoType.isSameBonus());
    assertEquals(30000000, lottoType.getMoney());
  }

  @Test
  @DisplayName("5개 번호")
  void 다섯개의_번호가_맞는_경우() {
    userNumber = List.of(1, 2, 3, 4, 5, 8);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.FIVE_SAME, lottoType);
    assertEquals(1500000, lottoType.getMoney());
  }

  @Test
  @DisplayName("4개 번호 + 보너스 => 4개 번호")
  void 네개의_번호가_맞고_보너스도_맞는_경우() {
    userNumber = List.of(1, 2, 3, 4, 7, 8);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.FOUR_SAME, lottoType);
    assertEquals(50000, lottoType.getMoney());
  }

  @Test
  @DisplayName("4개 번호 + 보너스 => 4개 번호")
  void 네개의_번호가_맞는_경우() {
    userNumber = List.of(1, 2, 3, 4, 8, 9);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.FOUR_SAME, lottoType);
    assertEquals(50000, lottoType.getMoney());
  }

  @Test
  @DisplayName("3개 번호 + 보너스 => 3개 번호")
  void 세개의_번호가_맞고_보너스도_맞는_경우() {
    userNumber = List.of(1, 2, 3, 7, 8, 9);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.THREE_SAME, lottoType);
    assertEquals(5000, lottoType.getMoney());
  }

  @Test
  @DisplayName("3개 번호")
  void 세개의_번호가_맞는_경우() {
    userNumber = List.of(1, 2, 3, 8, 9, 10);
    LottoType lottoType = LottoType.calc(lottoNumber, bonusNumber, userNumber);

    assertEquals(LottoType.THREE_SAME, lottoType);
    assertEquals(5000, lottoType.getMoney());
  }

}

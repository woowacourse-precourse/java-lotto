package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumbersTest {

  @DisplayName("로또 번호에 문자가 있으면 예외가 발생한다.")
  @Test
  void createLottoAlphabet() {
    String lottoNum = "1,2,3,4,6,a";
    String bonusNum = "7";

    assertThatThrownBy(() -> new InputNumbers(lottoNum, bonusNum))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void createLottoNumAndBonusNumDuplicatedNumber() {
    String lottoNum = "1,2,3,4,6,5";
    String bonusNum = "6";

    assertThatThrownBy(() -> new InputNumbers(lottoNum, bonusNum))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("성공테스트")
  @Test
  void createLottoSuccess() {
    String lottoNum = "1,2,3,4,6,5";
    String bonusNum = "7";

    List<Integer> answerLottoNum  = List.of(1,2,3,4,6,5);
    Integer answerBonusNum = 7;

    InputNumbers inputNumbers = new InputNumbers(lottoNum, bonusNum);

    assertThat(inputNumbers.lottoNumbers).isEqualTo(answerLottoNum);
    assertThat(inputNumbers.bonusNumber).isEqualTo(answerBonusNum);
  }
}
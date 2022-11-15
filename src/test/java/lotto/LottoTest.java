package lotto;

import lotto.domain.Judge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Judge judge;
    @BeforeEach
    void setUp() {
        judge = new Judge();
    }
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkBounusNumberIsContainedInWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> judge.isNotContain(lotto, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000으로 나누어 떨어지지않으면 예외가 발생한다.")
    @Test
    void inputAmountIs1000Times() {
        assertThatThrownBy(() -> judge.correctAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 금액이 자연수가 아니면 예외가 발생한다.")
    @Test
    void inputAmountIsNaturalNumber() {
        assertThatThrownBy(() -> judge.amountIsNaturalNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 번호가 범위밖이면 예외를 발생한다.")
    @Test
    void isInputNumbersCorrectRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 번호에 숫자가 아닌값이 있으면 예외를 발생한다.")
    @Test
    void isInputNumbersConsistOfNumber() {
        assertThatThrownBy(() -> judge.isAllNumber("1,2,3,a,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

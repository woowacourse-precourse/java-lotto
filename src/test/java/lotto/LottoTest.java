package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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
        assertThatThrownBy(() -> Application.validLuckyNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        Lotto temp = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 3;
        assertThatThrownBy(() -> temp.validBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 몇개 맞췄나 계산")
    @Test
    void compareLottoLuckyNumbers() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto luckyNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(input.getWinningNum(luckyNum))
                .isEqualTo(6);
    }

    @DisplayName("확률계산")
    @Test
    void profitTest() {
        int numOfLottos = 8;
        int totalPrice = 5000;
        assertThat(Application.getProfit(totalPrice, numOfLottos))
                .isEqualTo(62.5f);
    }
}

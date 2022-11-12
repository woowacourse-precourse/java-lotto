package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void checkLottoMoney1() {
        assertThatThrownBy(() -> new Validation("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 포함됐을 경우 예외가 발생한다.")
    @Test
    void checkLottoMoney2() {
        assertThatThrownBy(() -> new Validation("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1미만이거나 45 초과할 경우 예외가 발생한다.")
    @Test
    void checkLottoNumbers1() {
        assertThatThrownBy(() -> new Validation(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 8000원, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void calculateRate1() {
        assertThat(Calculation.getProfitRate(8000, 5000))
                .isEqualTo("62.5%");
    }

    @DisplayName("구매 금액 5000, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void calculateRate2() {
        assertThat(Calculation.getProfitRate(5000, 5000))
                .isEqualTo("100.0%");
    }

    @DisplayName("로또 1등 당첨 테스트")
    @Test
    void calculateWin1() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(5);
    }

    @DisplayName("로또 낙첨 테스트")
    @Test
    void calculateWin2() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(8, 9, 10, 11, 12, 13)))
                .isEqualTo(0);
    }
}

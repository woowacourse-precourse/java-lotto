package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("100원 이하의 단위가 입력되면 예외가 발생한다.")
    @Test
    void 가격_입력_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Cash.countPurchaseQuantity("1100");
                })
                .withMessageContaining("[ERROR]");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Cash.countPurchaseQuantity("1010");
                })
                .withMessageContaining("[ERROR]");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Cash.countPurchaseQuantity("1001");
                })
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액에 따른 로또 수량을 출력한다.")
    @Test
    void 로또수량_테스트() {
        assertThat(Cash.countPurchaseQuantity("150000")).isEqualTo(150);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverFlow() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverFlow2() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 0, 3, 4, 45, 40)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 번호_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    LottoMachine.getWinningNumbers("1,2,3,4,4,6");
                })
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호중에서 보너스 번호가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_보너스_번호_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Exceptions.compareWinningNumbersWithBonusNumbers(List.of(List.of("1", "2", "3", "4", "5", "6"), List.of("1")));
                })
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스번호가 1개가 아닐 때 예외 발생하는지 확인")
    @Test
    void 보너스_번호_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    LottoMachine.getBonusNumber("2, 4");
                })
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호 사이에 (,)가 아닌 다른 것이 오면 예외가 발생한다.")
    @Test
    void 콤마_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    LottoMachine.getWinningNumbers("2! 4");
                })
                .withMessageContaining("[ERROR]");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    LottoMachine.getWinningNumbers("2 4");
                })
                .withMessageContaining("[ERROR]");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    LottoMachine.getWinningNumbers("2-4");
                })
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("총 수익률 계산 테스트")
    @Test
    void 총_수익률_계산_테스트() {
        assertThat(Application.printEarningsRate(List.of(15), 1500000))
                .isEqualTo("총 수익률은 " + 10000.0 + "%입니다.");
    }

}

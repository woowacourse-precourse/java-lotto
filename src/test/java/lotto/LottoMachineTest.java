package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    public static final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구매한 로또 개수 확인")
    @Test
    void 구매한_로또_개수() {
        int input = 8000;
        int lottoCnt = lottoMachine.getLottoBuyCount(input);
        assertThat(lottoCnt).isEqualTo(input / LottoInfo.PRICE.getValue());
    }

    @DisplayName("올바른 당첨 번호 입력 테스트")
    @Test
    void 올바른_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoMachine.getWinningNumbers(input)).isEqualTo(input);
    }

    @DisplayName("유효하지 않은 당첨 번호 입력 테스트")
    @Test
    void 유효하지_않은_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> lottoMachine.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 보너스 번호 입력 테스트")
    @Test
    void 올바른_보너스_번호_입력() {
        int bonus = 35;
        assertThat(lottoMachine.getBonusNumber(bonus)).isEqualTo(bonus);
    }

    @DisplayName("유효하지 않은 보너스 번호 입력 테스트")
    @Test
    void 유효하지_않은_보너스_번호_입력() {
        int bonus = 3515;
        assertThatThrownBy(() -> lottoMachine.getBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
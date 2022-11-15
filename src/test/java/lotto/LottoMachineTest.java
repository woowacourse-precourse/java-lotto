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

    @DisplayName("1000원 이하인 금액이면 에러 발생")
    @Test
    void 기준보다_적은_금액() {
        int input = 500;
        assertThatThrownBy(() -> lottoMachine.getLottoBuyCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액이면 에러 발생")
    @Test
    void 나누어_떨어지지_않는_금액() {
        int input = 8105;
        assertThatThrownBy(() -> lottoMachine.getLottoBuyCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 당첨 번호 입력 테스트")
    @Test
    void 올바른_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoMachine.getWinningNumbers(input)).isEqualTo(input);
    }

    @DisplayName("개수가 유효하지 않은 당첨 번호 입력시 에러 발생")
    @Test
    void 개수가_유효하지_않은_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> lottoMachine.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("개수가 유효하지 않고 중복된 당첨 번호 입력시 에러 발생")
    @Test
    void 개수가_유효하지_않고_중복된_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 6);
        assertThatThrownBy(() -> lottoMachine.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위가 유효하지 않은 당첨 번호 입력시 에러 발생")
    @Test
    void 범위가_유효하지_않은_당첨_번호_입력() {
        List<Integer> input = List.of(1, 2, 3, 100, 5, 6);
        assertThatThrownBy(() -> lottoMachine.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 보너스 번호 입력 테스트")
    @Test
    void 올바른_보너스_번호_입력() {
        int bonus = 35;
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoMachine.getBonusNumber(bonus, winning)).isEqualTo(bonus);
    }

    @DisplayName("범위가 유효하지 않은 보너스 번호 입력시 에러 발생")
    @Test
    void 유효하지_않은_보너스_번호_입력() {
        int bonus = 3515;
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoMachine.getBonusNumber(bonus, winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호 입력시 에러 발생")
    @Test
    void 당첨_번호와_중복되는_보너스_번호_입력() {
        int bonus = 3;
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoMachine.getBonusNumber(bonus, winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void 로또_구매_테스트() {
        int count = 8;
        lottoMachine.buyLottos(count);
        for (Lotto lotto : lottoMachine.getLottos()) {
            System.out.println(lotto.toStringLotto());
        }
    }

    @DisplayName("당첨 통계 내기")
    @Test
    void 당첨_통계_내기() {
        lottoMachine.buyLottos(100);
        List<Integer> winning = Utils.pickUnique6Numbers();
        int bonus = 30;
        lottoMachine.calculateResult(winning, bonus);
    }
}
package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("로또 번호에 1~45범위가 넘는게 존재하면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByString() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 23))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void buyLotto() {
        LotteryMachine lotteryMachine = new LotteryMachine();

        assertThatThrownBy(() -> lotteryMachine.buyLottos(2003001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교하여 올바른 상금 가져오는지 확인")
    @Test
    void comparePrize() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 14, 15, 16));

        assertThat(winningNumbers.convertToPrize(lotto1)).isEqualTo(Prize.FIRST);
        assertThat(winningNumbers.convertToPrize(lotto2)).isEqualTo(Prize.THIRD);
        assertThat(winningNumbers.convertToPrize(lotto3)).isEqualTo(Prize.SECOND);
        assertThat(winningNumbers.convertToPrize(lotto4)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 출력 시 정렬되어 출력되는 지 확인")
    @Test
    void lottoNumberPrint() {
        Lotto lotto = new Lotto(List.of(5, 6, 42, 3, 10, 1));

        assertThat(lotto.toString()).isEqualTo("[1, 3, 5, 6, 10, 42]");
    }
}

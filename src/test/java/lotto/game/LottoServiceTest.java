package lotto.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("입력된 금액이 숫자가 아니면 에외가 발생한다.")
    void createMoneyByNotInteger() {
        // given
        String input = "12삼";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 1000으로 나눠떨어지지 않으면 예외가 발생한다")
    void createMoneyByNotDivisible1000() {
        // given
        String input = "12345";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000으로 나눠 떨어지는 금액만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 정상적이면 돈을 반환한다.")
    void createMoney() {
        // given
        String input = "10000";
        Money money = Money.of(10000);

        // expect
        assertThat(lottoService.convertInputToMoney(input))
                .isEqualTo(money);
    }

    @Test
    @DisplayName("올바른 번호를 입력하면 당첨 번호가 정상적으로 생성된다.")
    void createWinningLotto() {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        WinningLotto lotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // expect
        assertThat(lottoService.convertInputToWinningLotto(numbers, bonusNumber))
                .isEqualTo(lotto);
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber1() {
        // given
        String numbers = "1,2,3,4,5,46";
        String bonusNumber = "7";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToWinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber2() {
        // given
        String numbers = "0,1,2,3,4,5";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToWinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber3() {
        // given
        String numbers = "0,1,2,3,4,5,";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToWinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningLottoByDuplicate() {
        // given
        String input = "1,2,3,4,5,5";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToWinningLotto(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 보너스 번호와 중복되면 예외가 발생한다.")
    void createWinningLottoByDuplicateBonusNumber() {
        // given
        String input = "1,2,3,4,5,6";
        String bonusNumber = "6";

        // expect
        assertThatThrownBy(() -> lottoService.convertInputToWinningLotto(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 중복이 있습니다.");
    }

    @Test
    @DisplayName("로또 구매가 정상적으로 되야한다")
    void buyLotto() {
        // given
        Money money = Money.of(10000);

        // then
        List<Lotto> lottos = lottoService.buyLotto(money);

        // when
        assertThat(lottos.size())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("로또 번호가 3개 같으면 5등이어야 한다")
    void winningConfirmBy3NumberMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("로또 번호가 3개 같고 보너스 번호가 맞으면 4등이어야 한다")
    void winningConfirmBy3NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 4개 같으면 4등이어야 한다")
    void winningConfirmBy4NumberMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 5개 같으면 3등이어야 한다")
    void winningConfirmBy5NumberMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("로또 번호가 6개 같으면 1등이어야 한다")
    void winningConfirmBy6NumberMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("로또 번호가 5개 같고 보너스 번호가 맞으면 2등이어야 한다")
    void winningConfirmBy5NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.SECOND);
    }
}
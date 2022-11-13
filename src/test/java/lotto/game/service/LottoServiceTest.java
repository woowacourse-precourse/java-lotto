package lotto.game.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.LottoGrade;
import lotto.game.domain.Money;
import lotto.game.domain.WinningLotto;
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
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("로또 번호가 3개 같고 보너스 번호가 맞으면 4등이어야 한다")
    void winningConfirmBy3NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 4개 같으면 4등이어야 한다")
    void winningConfirmBy4NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 5개 같으면 3등이어야 한다")
    void winningConfirmBy5NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("로또 번호가 6개 같으면 1등이어야 한다")
    void winningConfirmBy6NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("로또 번호가 5개 같고 보너스 번호가 맞으면 2등이어야 한다")
    void winningConfirmBy5NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.SECOND);
    }
}
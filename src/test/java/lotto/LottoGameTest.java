package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAccounting;
import lotto.domain.LottoGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @DisplayName("최소 금액 미만으로 로또를 구매하는 경우 예외가 발생한다.")
    @Test
    void buyLottoWithNotEnoughMoney() {
        LottoGame game = new LottoGame(999);

        assertThatThrownBy(() -> {
            game.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원으로 로또를 구매하는 경우 예외가 발생한다.")
    @Test
    void buyLottoWithNoMoney() {
        LottoGame game = new LottoGame(0);

        assertThatThrownBy(() -> {
            game.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 금액으로 로또를 구매할 경우 예외가 발생한다.")
    @Test
    void buyLottoWithWrongUnitPrice() {
        LottoGame game = new LottoGame(1500);

        assertThatThrownBy(() -> {
            game.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매가 정상적으로 이루어져야 한다.")
    @Test
    void buyLottoFunctionalTest() {
        int money = 35000;
        int lottoPrice = 1000;
        LottoGame game = new LottoGame(35000);

        game.buy();
        List<Lotto> lotto = game.getLotto();

        Assertions.assertThat(lotto.size()).isEqualTo(money / lottoPrice);
    }

    @DisplayName("로또의 결과가 올바르게 나와야 한다.")
    @Test
    void getResultFunctionalTest() {
        LottoGame game = new LottoGame(0);

        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 45))); // 3등
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 44, 45))); // 4등
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 44, 45))); // 4등
        lotto.add(new Lotto(List.of(1, 2, 3, 43, 44, 45))); // 5등

        game.setWinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        game.setBonusNumber(7);
        game.setLotto(lotto);
        game.getResult();

        int[] expected = {2, 1, 1, 2, 1};
        int[] result = game.getMatchTable();

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("수익률 계산이 정상적으로 이루어져야 한다.")
    @Test
    void calcRateOfReturnFunctionalTest() {
        int[] matches = {0, 0, 0, 0, 1};
        int money = 8000;

        LottoGame game = new LottoGame(money);
        game.setMatchTable(matches);

        BigDecimal result = LottoAccounting.getROR(game);
        BigDecimal expected = new BigDecimal("62.5");

        Assertions.assertThat(result).isEqualTo(expected);
    }
}

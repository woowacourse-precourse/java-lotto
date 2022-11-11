package lotto.service;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    void setSystemInput(String command) {
        System.setIn(new ByteArrayInputStream(command.getBytes()));
    }

    @Test
    @DisplayName("플레이어가 구매한 로또가 playerPurchaseLottos 필드에 제대로 들어가야 한다.")
    void setPlayerPurchaseLottos() {
        // given
        LottoService lottoService = new LottoService();
        // when
        lottoService.setPlayerPurchaseLottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));
        // then
        assertThat(lottoService.playerPurchaseLottos).hasSize(3);
    }

    @Test
    @DisplayName("로또 10장 금액으로 구매 시 10장이 구입되어야 한다.")
    void purchaseLottos() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput(String.valueOf(10 * LOTTO_PRICE));
        // when
        List<Lotto> lottos = lottoService.purchaseLottos();
        // then
        assertThat(lottos).hasSize(10);
    }

    @Test
    @DisplayName("로또 구매 시 로또 금액 단위로 나누어 떨어지지 않을 때 예외가 발생한다.")
    void purchaseLottosDoNotDivide() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput(String.valueOf(LOTTO_PRICE + 1));
        // when
        // then
        assertThatThrownBy(lottoService::purchaseLottos)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 입력한 대로 로또 구매 금액을 반환해야 한다.")
    void inputPurchasePrice() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput(String.valueOf(LOTTO_PRICE));
        // when
        int purchasePrice = lottoService.inputPurchasePrice();
        // then
        assertThat(purchasePrice).isEqualTo(LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 구매 금액은 숫자여야 한다.")
    void inputPurchasePrice_NotNumeric() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("ABC");
        // when
        // then
        assertThatThrownBy(lottoService::inputPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또를 생성해서 반환해준다.")
    void generateLotto() {
        // given
        LottoService lottoService = new LottoService();
        // when
        Lotto lotto = lottoService.generateLotto();
        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("당첨번호는 로또의 숫자 개수와 같아야 한다.")
    public void inputWinningLotto_validCount() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,4,5,6,7");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호는 숫자여야 한다.")
    public void inputWinningLotto_numeric() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,ab,5,6");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 숫자여야 한다.")
    public void inputWinningLotto_bonusNumber_numeric() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,4,5,6\na");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
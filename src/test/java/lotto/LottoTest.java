package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.Constant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.OVER_THAN_NUMBER_OF_LOTTO.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_OVERLAP.getMessage());
    }

    @DisplayName("입력된 로또 번호가 로또 숫자의 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 80)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
    }

    @DisplayName("넣은 금액으로 구매할 수 있는 로또의 개수와 출력된 로또의 개수가 일치한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9, 13, 19})
    void checkBuyingLotto(int input) {
        LottoController lottoController = new LottoController();
        int myMoney = input * LOTTO_PRICE;
        Money money = new Money(myMoney);

        List<Lotto> lottos = lottoController.getLottos(money);

        assertThat(lottos.size()).isEqualTo(input);
    }
}

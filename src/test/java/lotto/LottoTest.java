package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberCreator;
import lotto.domain.LottoStore;
import lotto.ui.InputUi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("사용자가 구입 금액을 숫자로 입력 안할 시 예외가 발생한다.")
    @Test
    void inputBuyAmountByString() {
        String money = "100kd";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoStore lottoStore = new LottoStore(new LottoNumberCreator());
        InputUi inputUi = new InputUi();
        String buyAmountBill = inputUi.inputBuyAmount();

        assertThatThrownBy(() -> lottoStore.buyLotto(buyAmountBill))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입 금액을 1,000단위로 입력 안할 시 예외가 발생한다.")
    @Test
    void inputBuyAmountByThousandUnits() {
        String money = "11111";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoStore lottoStore = new LottoStore(new LottoNumberCreator());
        InputUi inputUi = new InputUi();
        String buyAmountBill = inputUi.inputBuyAmount();

        assertThatThrownBy(() -> lottoStore.buyLotto(buyAmountBill))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 쉼표(,)를 기준으로 입력 안할 시 예외가 발생한다.")
    @Test
    void inputLottoWinNumberByComma() {
        String money = "1! 2, 3, 4, 5, 6";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        InputUi inputUi = new InputUi();
        String lottoWinNumber = inputUi.inputLottoWinNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoWinNumber(lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

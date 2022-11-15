package lotto;

import lotto.domain.*;
import lotto.ui.InputUi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 당첨 번호 숫자를 입력 안할 시 예외가 발생한다.")
    @Test
    void inputLottoWinNumberByString() {
        String money = "1, two, 3, 4, 5, 6";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        InputUi inputUi = new InputUi();
        String lottoWinNumber = inputUi.inputLottoWinNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoWinNumber(lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 1부터 45 사이의 숫자를 입력 안할 시 예외가 발생한다.")
    @Test
    void inputLottoWinNumberByNumberRange() {
        String money = "0, 2, 3, 4, 5, 6";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        InputUi inputUi = new InputUi();
        String lottoWinNumber = inputUi.inputLottoWinNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoWinNumber(lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호 숫자를 입력 안할 시 예외가 발생한다.")
    @Test
    void inputLottoBonusNumberByString() {
        String money = "one";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        Lotto lottoWinNumber = lottoNumberCreator.createLottoWinNumber("1, 2, 3, 4, 5, 6");
        InputUi inputUi = new InputUi();
        String lottoBonusNumber = inputUi.inputLottoBonusNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoBonusBall(lottoBonusNumber, lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호 1부터 45사이의 숫자를 입력 안할 시 예외가 발생한다.")
    @Test
    void inputLottoBonusNumberByNumberRange() {
        String money = "0";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        Lotto lottoWinNumber = lottoNumberCreator.createLottoWinNumber("1, 2, 3, 4, 5, 6");
        InputUi inputUi = new InputUi();
        String lottoBonusNumber = inputUi.inputLottoBonusNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoBonusBall(lottoBonusNumber, lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 로또 당첨 번호 중 중북된 숫자를 입력 시 예외가 발생한다.")
    @Test
    void inputLottoBonusNumberByDuplicatedNumber() {
        String money = "1";
        InputStream is = new ByteArrayInputStream(money.getBytes());
        System.setIn(is);

        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
        Lotto lottoWinNumber = lottoNumberCreator.createLottoWinNumber("1, 2, 3, 4, 5, 6");
        InputUi inputUi = new InputUi();
        String lottoBonusNumber = inputUi.inputLottoBonusNumber();

        assertThatThrownBy(() -> lottoNumberCreator.createLottoBonusBall(lottoBonusNumber, lottoWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 로또 당첨 개수")
    @Test
    void userWinLottoAmount() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1,2,10,11,12,13)));
        lottoNumbers.add(new Lotto(List.of(1,2,3,11,12,13)));
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,12,13)));
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,13)));
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> lottoWinNumber = List.of(1,2,3,4,5,6);
        int lottoBonusBall = 7;
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoNumbers, lottoWinNumber, lottoBonusBall);

        Map<LottoRank, Integer> lottoWinAmounts = lottoAnalyzer.analyzeLottoWin();
        for (LottoRank lottoRank : lottoWinAmounts.keySet()) {
            assertThat(lottoWinAmounts.get(lottoRank)).isEqualTo(1);
        }
    }
    
    @DisplayName("로또 수익률 확인")
    @Test
    void userLottoProfitRate() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1,2,3,10,11,13)));
        for (int i = 0; i < 7; ++i) {
            lottoNumbers.add(new Lotto(List.of(1,2,9,10,11,13)));
        }
        List<Integer> lottoWinNumber = List.of(1,2,3,4,5,6);
        int lottoBonusBall = 7;
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoNumbers, lottoWinNumber, lottoBonusBall);

        Map<LottoRank, Integer> lottoWinAmounts = lottoAnalyzer.analyzeLottoWin();
        LottoProfitRate lottoProfitRate = new LottoProfitRate();
        double profitRate = lottoProfitRate.calculateProfitRate(lottoNumbers, lottoWinAmounts);
        assertThat(profitRate).isEqualTo(62.5);
    }
}

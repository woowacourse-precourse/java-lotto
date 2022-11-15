package lotto;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.UserInput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 숫자와 콤마가 아니면 예외가 발생한다.")
    @Test
    void winningNumberIsNotNumberAndComma() {
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.validateWinningNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값을 콤마를 기준으로 List에 저장한다.")
    @Test
    void isEqualsInputAndSetComma() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4");

        assertEquals(winningLotto.getWinningNumbers(),
                List.of(1, 2, 3, 4));
    }

    @DisplayName("입력받은 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void InputNumberIsNotNumber() {
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.validateIsDigit("night"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 금액이 1000 단위가 아니라면 예외가 발생한다.")
    @Test
    void createMoneyBy1000() {
        assertThatThrownBy(() -> new Money("1004"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoBonusByInRange() {
        assertThatThrownBy(() -> new LottoBonus("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 기존 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void createLottoBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoBonus("45", List.of(1, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액을 넣으면 수익률을 계산해준다.")
    @Test
    void calculateProfitRate() {
        Assertions.assertEquals(LottoManager.calculateProfitRate(8000, 5000), 62.5);
    }

    @DisplayName("로또 번호를 입력한 장수만큼 만들어준다.")
    @Test
    void createLottoNumber() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.makeRandomLottoNumber(3);

        assertThat(lottoManager.getRandomLottoNumber()
                .size())
                .isEqualTo(3);
    }

    @DisplayName("계산된 로또 결과가 알맞게 저장되는지 확인한다.")
    @Test
    void printLottoNumber() {
        LottoManager lottoManager = new LottoManager();
        LottoResultBoard lottoResultBoard = new LottoResultBoard();
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        LottoBonus lottoBonus = new LottoBonus("10", List.of(1, 2, 3, 4, 5, 6));
        List<List<Integer>> list = List.of(List.of(1, 2, 3, 4, 5, 10));

        lottoManager.calculateLottoRank(winningLotto, lottoResultBoard, list);

        assertThat(LottoResultBoard.getLottoResultBoard().get(LottoRank.SECOND))
                .isEqualTo(1);
    }
}

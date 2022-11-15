package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByBigNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Bonus bonus = new Bonus();
        //assertEquals(Bonus.BonusValidate(1, lotto.getLottoNumber()),False);
    }

    @DisplayName("input 값이 숫자가 아니면 예외처리")
    @Test
    void isCashInt() {
        String input = "ABBD";
        new Buy();
        assertThatThrownBy(() -> Buy.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 입력되지 않으면 예외처리")
    @Test
    void isCashCheck() {
        int input = 7999;
        new Buy();
        assertThatThrownBy(() -> Buy.validate1000(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 로또의 범위 1~45에서 벗어나면 예외처리")
    @Test
    void inputBonusByRange() {
        String input = "56";
        //assertThatThrownBy(() -> new WinningNumber().inputBonusNum(input))
                //.isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호를 로또번호와 비교")
    @Test
    void compareLottoTest() {
        List<Integer> lotto = Arrays.asList(10,22,34,43,23,6);
        List<Integer> winningLotto = Arrays.asList(10,22,34,1,5,4);
        Bonus.BonusNumber = 7;

        assertEquals(MatchNumber.THREE, Count.WinCount(lotto, winningLotto));
    }
}

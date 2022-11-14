package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호를 생성하여 개수 테스트, 중복 테스트를 진행한다.")
    @Test
    void createLottoRandomByDuplicatedNumber() {

        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        Lotto lotto = new Lotto(makeLottoNumber.returnLottoNumber());
    }

    @DisplayName("input 값이 숫자가 아니면 예외처리")
    @Test
    void isCashInt() {
        String input = "ABBD";
        assertThatThrownBy(() -> new Cash().Input(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 입력되지 않으면 예외처리")
    @Test
    void isCashCheck() {
        String input = "7999";
        assertThatThrownBy(() -> new Cash().Input(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 개수가 6개가 아니면 예외처리")
    @Test
    void inputWinningNumbersByOverSize() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> new WinningNumber().inputWinningNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 로또의 범위 1~45에서 벗어나면 예외처리")
    @Test
    void inputWinningNumberByRange() {
        String input = "1,46,2,3,4,5";
        assertThatThrownBy(() -> new WinningNumber().inputWinningNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 로또의 범위 1~45에서 벗어나면 예외처리")
    @Test
    void inputBonusByRange() {
        String input = "56";
        assertThatThrownBy(() -> new WinningNumber().inputBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 숫자가 아니면 예외처리")
    @Test
    void inputBonusCheck() {
        String input = "보너스";
        assertThatThrownBy(() -> new WinningNumber().inputBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호를 로또번호와 비교")
    @Test
    void compareLottoTest() {
        PrintLotto printLotto = new PrintLotto();
        PrintLotto.winnigCashType winThree = PrintLotto.winnigCashType.winThree;
        List<Integer> lotto = Arrays.asList(10,22,34,43,23,6);
        int[] winningLotto = {10,22,34,1,5,4};
        int bnsNum = 7;

        assertEquals(winThree, printLotto.inquiry(lotto, winningLotto, bnsNum));
    }

}

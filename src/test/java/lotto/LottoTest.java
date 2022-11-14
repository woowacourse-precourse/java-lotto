package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 입력하고 구매 수를 구하고, 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountTest() {
        BuyAmount buyAmount = new BuyAmount(14000);

        assertThat(buyAmount.buyLotto).isEqualTo(14);
    }

    @DisplayName("당첨 번호를 리스트에 저장, 예외 발생 테스트")
    @Test
    void winningNumbersTest() {
        WinningNumberToList winningNumberToList = new WinningNumberToList();
        winningNumberToList.setWinNumbers("6,4,3,2,5,1");
        List<Integer> lst = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };

        assertThat(winningNumberToList.winNumbers).isEqualTo(lst);
    }

    @DisplayName("당첨 번호를 비교한 뒤 일치하는 수에 대해 문자열로 저장하도록 함")
    @Test
    void winningNumbersCheckTest() {
        LottoCheck lottoCheck = new LottoCheck(List.of(List.of(1,2,3,4,5,7)), List.of(1,2,3,4,5,6), 7);

        assertThat(lottoCheck.checkRank).isEqualTo(List.of("5+"));
    }

}

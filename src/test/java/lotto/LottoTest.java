package lotto;

import lotto.function.Function;
import lotto.function.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("제시된 금액에 맞는 개수의 로또를 생성하였는지 확인한다.")
    @Test
    void purchaseLottoTest() {
        assertThat(Function.purchaseLotto(7000).size()).isEqualTo(7);
    }


    @DisplayName("숫자가 아니거나, 1,000원 단위가 아닌 값이 입력되었을 때 예외를 생성한다.")
    @Test
    void validPriceTest() {
        String test1 = "1234";
        String test2 = "1000j";
        assertThatThrownBy(() -> Function.validPrice(test1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Function.validPrice(test2)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값이 입력되었을 때 예외를 생성한다.")
    @Test
    void changeTypeofWinningNumberTest() {
        String[] test = new String[]{"a", "b", "c", "d", "e", "f"};
        assertThatThrownBy(() -> Function.changeTypeofWinningNumber(test)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리가 아니거나, 숫자가 겹치거나, 범위를 넘었을 때 예외를 생성한다.")
    @Test
    void validWinningNumberTest() {
        List<Integer> test1 = List.of(1, 2, 3, 4, 5);
        List<Integer> test2 = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> test3 = List.of(1, 2, 3, 4, 5, 99);
        assertThatThrownBy(() -> Function.validWinningNumber(test1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Function.validWinningNumber(test2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Function.validWinningNumber(test3)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니거나, 범위를 넘었거나, 당첨 번호에 이미 존재할때 예외를 생성한다.")
    @Test
    void validBonusTest() {
        List<Integer> win = List.of(1, 2, 3, 4, 5, 6);
        String test1 = "a";
        String test2 = "99";
        String test3 = "1";
        assertThatThrownBy(() -> Function.validBonus(test1, win)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Function.validBonus(test2, win)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Function.validBonus(test3, win)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호 및 보너스를 비교하여 맞는 개수를 출력한다.")
    @Test
    void countMatchingTest() {
        List<Integer> test1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> test2 = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> test3 = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> test4 = List.of(1, 2, 3, 4, 9, 8);
        List<Integer> test5 = List.of(1, 2, 3, 10, 9, 8);
        List<Integer> test6 = List.of(1, 2, 11, 10, 9, 8);
        List<Integer> win = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(test1);
        Lotto lotto2 = new Lotto(test2);
        Lotto lotto3 = new Lotto(test3);
        Lotto lotto4 = new Lotto(test4);
        Lotto lotto5 = new Lotto(test5);
        Lotto lotto6 = new Lotto(test6);
        assertThat(Function.countMatching(lotto1, win, 7)).isEqualTo(7);
        assertThat(Function.countMatching(lotto2, win, 7)).isEqualTo(6);
        assertThat(Function.countMatching(lotto3, win, 7)).isEqualTo(5);
        assertThat(Function.countMatching(lotto4, win, 7)).isEqualTo(4);
        assertThat(Function.countMatching(lotto5, win, 7)).isEqualTo(3);
        assertThat(Function.countMatching(lotto6, win, 7)).isEqualTo(2);
    }

    @DisplayName("count를 맞는 list로 변환한다.")
    @Test
    void winLottoTest() {
        List<Integer> test1 = List.of(1, 0, 0, 0, 0);
        List<Integer> test2 = List.of(0, 1, 0, 0, 0);
        List<Integer> test3 = List.of(0, 0, 1, 0, 0);
        List<Integer> test4 = List.of(0, 0, 0, 1, 0);
        List<Integer> test5 = List.of(0, 0, 0, 0, 1);
        assertThat(Function.winLotto(3)).isEqualTo(test1);
        assertThat(Function.winLotto(4)).isEqualTo(test2);
        assertThat(Function.winLotto(5)).isEqualTo(test3);
        assertThat(Function.winLotto(6)).isEqualTo(test4);
        assertThat(Function.winLotto(7)).isEqualTo(test5);
    }

    @DisplayName("결과에 맞는 상금을 계산한다.")
    @Test
    void calculateWinningTest() {
        List<Integer> test = List.of(5, 4, 3, 2, 1);
        assertThat(Function.calculateWinning(test)).isEqualTo(2064725000);
    }

    @DisplayName("사용한 비용과 상금으로 수익률을 계산한다.")
    @Test
    void calculateYieldTest() {
        assertThat(Function.calculateYield(4000, 5000)).isEqualTo("125.0");
    }
}

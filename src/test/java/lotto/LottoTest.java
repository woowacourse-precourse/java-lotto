package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 비어있다면 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 이외의 값이 들어올 수 없다.")
    @Test
    void createLottoByNotNumber() {
        String input = "123abc";

        assertThatThrownBy(() -> LottoView.isNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1등은 6개 번호가 일치해야 한다.")
    @Test
    void checkPrize1() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Winning winning = winningNumber.checkLotto(myLotto, 0);
        Assertions.assertThat(winning).isEqualTo(Winning.SIX);
    }

    @DisplayName("로또 2등은 5개 번호와 보너스 번호가 일치해야 한다.")
    @Test
    void checkPrize2() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        Winning winning = winningNumber.checkLotto(myLotto, 7);
        Assertions.assertThat(winning).isEqualTo(Winning.FIVE_WITH_BONUS);
    }

    @DisplayName("로또 3등은 5개 번호가 일치해야 한다.")
    @Test
    void checkPrize3() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));

        Winning winning = winningNumber.checkLotto(myLotto, 7);
        Assertions.assertThat(winning).isEqualTo(Winning.FIVE);
    }

    @DisplayName("로또 4등은 4개 번호가 일치해야 한다.")
    @Test
    void checkPrize4() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 30, 40));

        Winning winning = winningNumber.checkLotto(myLotto, 10);
        Assertions.assertThat(winning).isEqualTo(Winning.FOUR);
    }

    @DisplayName("로또 5등은 3개 번호가 일치해야 한다.")
    @Test
    void checkPrize5() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42));

        Winning winning = winningNumber.checkLotto(myLotto, 10);
        Assertions.assertThat(winning).isEqualTo(Winning.THREE);
    }

    @DisplayName("산 모든 로또의 등수를 계산한다.")
    @Test
    void checkLottoAll() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 13, 14, 15)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 25)));
        lottos.add(new Lotto(Arrays.asList(30, 31, 32, 33, 34, 35)));

        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> win = winningNumber.checkLottoAll(lottos, 25);
        Assertions.assertThat(win).isEqualTo(Arrays.asList(0, 1, 1, 0, 0, 1, 0));
    }

    @DisplayName("모든 로또의 등수와 수익률 계산 테스트")
    @Test
    void checkProfit() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 13, 14, 15)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 25)));
        lottos.add(new Lotto(Arrays.asList(30, 31, 32, 33, 34, 35)));

        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> win = winningNumber.checkLottoAll(lottos, 25);
        String result = Lotto.caculateProfit(win, 4000);
        Assertions.assertThat(result).isEqualTo("50750125");
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ValidatorTest.WINNING_NUMBERS;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 6개 일치하면 LottoResult.SIX를 반환한다.")
    @Test
    void test1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.SIX);
    }

    @DisplayName("당첨번호가 5개 일치하고 보너스번호가 일치하지 않으면 LottoResult.FIVE를 반환한다.")
    @Test
    void test2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.FIVE);
    }

    @DisplayName("당첨번호가 5개 일치하고 보너스번호가 일치하면 LottoResult.FIVE_WITH_BONUS를 반환한다.")
    @Test
    void test3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.FIVE_WITH_BONUS);
    }

    @DisplayName("당첨번호가 4개 일치하면 LottoResult.FOUR를 반환한다.")
    @Test
    void test4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.FOUR);
    }

    @DisplayName("당첨번호가 3개 일치하면 LottoResult.THREE를 반환한다.")
    @Test
    void test5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.THREE);
    }

    @DisplayName("당첨번호가 일치갯수가 2개 이하면 LottoResult.ESLE를 반환한다.")
    @Test
    void test6() {
        Lotto lotto = new Lotto(List.of(1, 2, 32, 43, 44, 45));
        assertThat(lotto.result(WINNING_NUMBERS, 7)).isEqualTo(LottoResult.ELSE);
    }

}

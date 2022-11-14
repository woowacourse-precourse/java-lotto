package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 보다 클 경우 예외가 발생한다.")
    @Test
    void createLottoByHigherThanValidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 보다 작을 경우 예외가 발생한다.")
    @Test
    void createLottoByLowerThanValidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 일치 시 1등으로 간주한다.")
    @Test
    void compareTwoLottoFirstPlace() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(1);
    }

    @DisplayName("5자리 일치와 보너스 번호 일치 시 2등으로 간주한다.")
    @Test
    void compareTwoLottoSecondPlace() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonus = 6;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(2);
    }

    @DisplayName("5자리 일치와 보너스 번호 불일치 시 3등으로 간주한다.")
    @Test
    void compareTwoLottoThirdPlace() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonus = 8;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(3);
    }

    @DisplayName("4자리 일치 시 4등으로 간주한다.")
    @Test
    void compareTwoLottoFourthPlace() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        int bonus = 9;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(4);
    }

    @DisplayName("3자리 일치 시 5등으로 간주한다.")
    @Test
    void compareTwoLottoFifthPlace() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonus = 10;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(5);
    }
    @DisplayName("3자리 미만 일치 시 미당첨으로 간주한다.")
    @Test
    void compareTwoLottoNothing() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        int bonus = 11;
        assertThat(userLotto.compare(winningLotto, bonus)).isEqualTo(6);
    }

}

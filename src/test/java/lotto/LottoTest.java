package lotto;

import java.util.NoSuchElementException;
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
    @DisplayName("로또 번호에 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumbers() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createUserUsingCharacter() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성R
        assertThatThrownBy(() -> new User("1000a"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createUserHavingRemainder() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성R
        assertThatThrownBy(() -> new User("11500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호와 보너스 번호가 중복이면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 45, 6));
        int bonus = 45;
        assertThatThrownBy(() -> new Rank(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 중복이면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 45, 6));
        int bonus = 45;
        assertThatThrownBy(() -> new Rank(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

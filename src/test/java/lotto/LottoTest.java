package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 46, 2, 3, 4, 5)))
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

    @DisplayName("당첨 번호와 동일한 숫자 개수를 확인한다.")
    @Test
    void checkCountOfSameNumber(){
        Lotto playerLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winLotto = new Lotto(List.of(1,5,8,9,10,11));
        int result = playerLotto.countSameNumber(winLotto.getNumbers());
        assertThat(result == 2);
    }

    @DisplayName("보너스 번호와 동일한 숫자가 있는지 확인한다.")
    @Test
    void checkBonusOfSameNumber(){
        Lotto playerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 3;
        boolean result = playerLotto.isBonusNumber(bonus);
        assertThat(result == true);
    }
}

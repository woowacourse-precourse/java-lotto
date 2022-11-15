package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

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

    @DisplayName("로또 번호에 45초과인 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoNumberNyOverNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 게산기가 정확한지 체크한다.")
    @Test
    void checkCompare() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.compare(userLotto)).isEqualTo(6);
    }
    @DisplayName("로또가 보너스 숫자를 포함하고 있는지 체크한다.")
    @Test
    void checkBonusNum(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.containBonus(3)).isEqualTo(true);
    }
    @DisplayName("보너스 번호가 올바른 번호가 아니면 예외를 발생시킨다.")
    @Test
    void checkBonus(){
        assertThatThrownBy(() -> Check.checkBonusNum("숫자"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
